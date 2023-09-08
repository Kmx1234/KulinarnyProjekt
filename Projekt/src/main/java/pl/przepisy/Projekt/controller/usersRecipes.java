package pl.przepisy.Projekt.controller;

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

    @GetMapping("/list")
    public String listRecipes(Model model) {
        List<recipe> allRecipes = recipeRepository.findAll();
        model.addAttribute("allRecipes", allRecipes);
        return "usersRecipes"; // Zwraca widok, który wyświetla listę przepisów
    }
}
