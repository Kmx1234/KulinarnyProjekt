package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
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
import pl.przepisy.Projekt.service.RecipeService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/addRecipe")
public class recipeController {

    private final RecipeService recipeService;

    @GetMapping("/createRecipe")
    public String showRecipeForm(Model model, HttpSession session) {
        model.addAttribute("recipe", new recipe());
        return "recipe"; // Zwraca nazwę pliku HTML z formularzem
    }

    @PostMapping("/createRecipe")
    public String createRecipe(@Valid @ModelAttribute("recipe") recipe recipe, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            System.out.println("Błędy walidacji: " + result.getAllErrors());
            return "recipe"; // Jeśli są błędy walidacji, wracamy na formularz
        }
        ; // Przypisanie bieżącego użytkownika do przepisu
        recipeService.save(recipe);

        return "redirect:/addIngredients/createIngredients"; // Przekierowanie użytkownika z powrotem do formularza po zapisaniu przepisu
    }

    @GetMapping("/saveRecipe")
    public String showRecipeForm2() {
        return "redirect:/dashboard"; // Zwraca nazwę pliku HTML z formularzem
    }

    @PostMapping("/saveRecipe")
    public ResponseEntity<recipe> saveRecipe(@Valid @RequestBody recipe recipe) {
        recipe savedRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }


    @GetMapping("/{id}")
    public ResponseEntity<recipe> getRecipeById(@PathVariable Long id) {
        recipe recipe = recipeService.getRecipeById(id);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<recipe> updateRecipe(@PathVariable Long id, @Valid @RequestBody recipe recipe) {
        recipe.setId(id);
        recipe updatedRecipe = recipeService.updateRecipe(recipe);
        return updatedRecipe != null ? ResponseEntity.ok(updatedRecipe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<recipe> getRecipeByUserId(@PathVariable Long id) {
        recipe recipe = recipeService.getRecipeByUserId(id);
        return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }


//    @PostMapping("/saveRecipe")
//    public String saveRecipe(@RequestParam("title") String title, @RequestParam("description") String description, HttpSession session) {
//            Long userId = (Long) session.getAttribute("users_id");
//
//            recipe recipe = new recipe();
//            recipe.setTitle(title);
//            recipe.setDescription(description);
//            recipe.setUserId(userId);
//            recipeService.save(recipe); // Przy użyciu serwisu przepisu do zapisu w bazie danych
//
//            return "redirect:/dashboard"; // Przekierowanie użytkownika z powrotem do formularza po zapisaniu przepisu
//    }
}
