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

@Controller
@RequiredArgsConstructor
@RequestMapping("/addUserRecipes")
public class usersRecipeController {

    private final UserRecipesService userRecipesService;


    @PostMapping
    public ResponseEntity<userRecipes> createUserRecipes(@Valid @RequestBody userRecipes userRecipes) {
        userRecipesService.saveUserRecipes(userRecipes);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRecipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<userRecipes> getUserRecipesById(@PathVariable Long id) {
        userRecipes userRecipes = userRecipesService.getUserRecipesById(id);
        return userRecipes != null ? ResponseEntity.ok(userRecipes) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<userRecipes> updateUserRecipes(@PathVariable Long id, @Valid @RequestBody userRecipes userRecipes) {
        userRecipes.setId(id);
        userRecipes updatedUserRecipes = userRecipesService.updateUserRecipes(userRecipes);
        return updatedUserRecipes != null ? ResponseEntity.ok(updatedUserRecipes) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRecipes(@PathVariable Long id) {
        userRecipesService.deleteUserRecipes(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-recipe/{id}")
    public ResponseEntity<userRecipes> getUserRecipesByRecipeId(@PathVariable Long id) {
        userRecipes userRecipes = userRecipesService.getUserRecipesByRecipeId(id);
        return userRecipes != null ? ResponseEntity.ok(userRecipes) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<userRecipes> getUserRecipesByUserId(@PathVariable Long id) {
        userRecipes userRecipes = userRecipesService.getUserRecipesByUserId(id);
        return userRecipes != null ? ResponseEntity.ok(userRecipes) : ResponseEntity.notFound().build();
    }
}




