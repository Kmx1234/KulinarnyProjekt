package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.repository.RecipeRepository;

import java.util.List;

@Controller
@RequestMapping("/usersRecipes")
public class usersRecipes {

    @Autowired
    private RecipeRepository recipeRepository;

    //    @GetMapping("/list")
//    public String listRecipes(Model model) {
//        List<recipe> allRecipes = recipeRepository.findAll();
//        model.addAttribute("allRecipes", allRecipes);
//        return "usersRecipes"; // Zwraca widok, który wyświetla listę przepisów
//    }
//}
    @GetMapping("/list")
    public String listRecipes(Model model, HttpSession session) {
        boolean isLoggedIn = session.getAttribute("user") != null;
        List<recipe> allRecipes = recipeRepository.findAll();
        model.addAttribute("allRecipes", allRecipes);
        if (isLoggedIn) {
            return "usersRecipesForLogginUsers"; // Użytkownik jest zalogowany
        } else {
            return "usersRecipes"; // Użytkownik nie jest zalogowany
        }
    }
//    @PostMapping("/rate")
//    public String rateRecipe(@RequestParam("recipeId") Long recipeId, @RequestParam("rating") double rating, HttpSession session) {
//        user user = (user) session.getAttribute("user");
//        if (user == null) {
//            // Obsługa przypadku, gdy użytkownik nie jest zalogowany
//            return "redirect:/User/login"; // Przekieruj użytkownika na stronę logowania
//        }
//        recipe recipe = recipeService.getRecipeById(recipeId);
//        double averageRating = recipe.getAverageRating();
//        int numberOfRatings = recipe.getComments().size();
//        double newAverageRating = (averageRating * numberOfRatings + rating) / (numberOfRatings + 1);
//        recipe.setAverageRating(newAverageRating);
//        recipeService.save(recipe);
//        return "redirect:/dashboard";
//    }
}