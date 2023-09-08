package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
