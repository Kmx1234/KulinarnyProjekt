package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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
}