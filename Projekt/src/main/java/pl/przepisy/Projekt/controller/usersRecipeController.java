package pl.przepisy.Projekt.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.entity.userRecipes;
import pl.przepisy.Projekt.service.UserRecipesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/showAllRecipes")
public class usersRecipeController {

    UserRecipesService userRecipesService;

    @GetMapping("/all")
    public String showAllRecipes() {
        return "usersRecipes";
    }

}





