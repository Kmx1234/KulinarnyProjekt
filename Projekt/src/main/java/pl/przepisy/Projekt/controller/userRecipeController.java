package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.service.RecipeService;

import java.util.List;

@Controller
@RequestMapping("/userRecipe")
public class userRecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list")
    public String listUserRecipes(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (session.getAttribute("userId") == null) {
            System.out.println("Nie jesteś zalogowany");
        }


        List<recipe> userRecipes = recipeService.getRecipesByUserId(userId);

        model.addAttribute("userRecipes", userRecipes);
        return "userRecipes";
    }

    @PostMapping("/delete")
    public String deleteUserRecipe(@RequestParam("recipeId") Long recipeId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (session.getAttribute("userId") == null) {
            System.out.println("Nie jesteś zalogowany");
        }

        recipeService.deleteById(recipeId);

        return "redirect:/userRecipe/list";
    }

    @GetMapping("/edit/{recipeId}")
    public String editRecipe(@PathVariable Long recipeId, Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        recipe recipe = recipeService.getRecipeById(recipeId);
               model.addAttribute("recipe", recipe);

        return "editRecipe";
    }
    @PostMapping("/edit/{recipeId}")
    public String editRecipe(@PathVariable@RequestParam("recipeId") Long recipeId, @Valid @ModelAttribute("recipe") recipe recipe, BindingResult bindingResult, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        recipeService.getRecipeById(recipeId);
        recipeService.updateRecipe(recipe);

        return "redirect:/userRecipe/list";
    }
}
