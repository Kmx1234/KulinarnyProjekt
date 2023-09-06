package pl.przepisy.Projekt.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.przepisy.Projekt.entity.recipeIngredients;
import pl.przepisy.Projekt.service.IngredientsService;
@Controller
@RequiredArgsConstructor
@RequestMapping("/addIngredients")
public class ingredientsController {
    private final IngredientsService ingredientsService;

    @GetMapping("/createIngredients")
    public String showIngredientsForm() {
        return "ingredients";
    }

    @PostMapping
    public ResponseEntity<recipeIngredients> create(@RequestBody @Valid recipeIngredients ingredients) {
        return ResponseEntity.status(HttpStatus.CREATED).body((recipeIngredients) ingredientsService.create(ingredients));
    }
    @GetMapping("/{id}")
    public ResponseEntity<IngredientsService> getIngredientsById(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientsService.getIngredientsById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<IngredientsService> updateIngredients(@PathVariable Long id, @RequestBody @Valid recipeIngredients ingredients) {
        return ResponseEntity.ok(ingredientsService.updateIngredients(ingredients));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredients(@PathVariable Long id) {
        ingredientsService.deleteIngredients(id);
        return ResponseEntity.ok().build();
    }
}
