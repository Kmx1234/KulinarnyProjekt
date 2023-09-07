package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.entity.recipeIngredients;
import pl.przepisy.Projekt.service.IngredientsService;
@Controller
@RequiredArgsConstructor
@RequestMapping("/addIngredients")
public class ingredientsController {
    private final IngredientsService ingredientsService;

@GetMapping("/finish")
    public String finish(Model model) {
        return "dashboard";
    }

    @GetMapping("/createIngredients")
    public String showIngredientsForm(Model model) {
        model.addAttribute("ingredients", new recipeIngredients());
        return "ingredients";
    }

    @PostMapping("/createIngredients")
    public String createIngredients(@Valid @ModelAttribute("recipeIngredients") recipeIngredients recipeIngredients, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            System.out.println("Błędy walidacji: " + result.getAllErrors());
            return "ingredients";
        }
        recipe recipe = (recipe) session.getAttribute("recipe");
        recipeIngredients.setRecipe(recipe);
        ingredientsService.save(recipeIngredients);

        return "redirect:/addIngredients/createIngredients";
    }
}