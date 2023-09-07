package pl.przepisy.Projekt.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.recipeIngredients;

@Service
@RequiredArgsConstructor
public class IngredientsService {

    private IngredientsService ingredientsService;


    public recipeIngredients create(@Valid recipeIngredients ingredients) {
        return ingredientsService.create(ingredients);
    }

    public void saveIngredients(@Valid recipeIngredients ingredients) {
        ingredientsService.saveIngredients(ingredients);
    }

    public IngredientsService getIngredientsById(Long id) {
        return ingredientsService.getIngredientsById(id);
    }

    public IngredientsService updateIngredients(@Valid recipeIngredients ingredients) {
        return ingredientsService.updateIngredients(ingredients);
    }

    public void deleteIngredients(Long id) {
        ingredientsService.deleteIngredients(id);
    }

    public void save(recipeIngredients recipeIngredients) {
        ingredientsService.save(recipeIngredients);
    }
}
