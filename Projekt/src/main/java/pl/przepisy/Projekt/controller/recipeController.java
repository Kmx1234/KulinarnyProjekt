package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.entity.user;
import pl.przepisy.Projekt.service.RecipeService;

@Controller
@RequestMapping("/addRecipe")
public class recipeController {
    @Autowired
    private RecipeService recipeService;


    @GetMapping("/createRecipe")
    public String showRecipeForm(Model model, HttpSession session) {
        model.addAttribute("recipe", new recipe());
        return "recipe"; // Zwraca nazwę pliku HTML z formularzem
    }

    @PostMapping("/createRecipe")
    public String createRecipe(@Valid @ModelAttribute("recipe") recipe recipe, BindingResult result,
                               HttpSession session) {
        user user = (user) session.getAttribute("user");
        if (user == null) {
            // Obsługa przypadku, gdy użytkownik nie jest zalogowany
            return "redirect:/User/login"; // Przekieruj użytkownika na stronę logowania
        }
        if (result.hasErrors()) {
            System.out.println("Błędy walidacji: " + result.getAllErrors());
            return "recipe"; // Jeśli są błędy walidacji, wracamy na formularz
        }
        // Przypisanie bieżącego użytkownika do przepisu
        recipe.setUser(user);
        recipeService.save(recipe);

        return "redirect:/dashboard";
    }

}
