package pl.przepisy.Projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.repository.RecipeRepository;

import java.util.List;


@Service

public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;


public List<recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.getRecipeByUserId(userId);
    }

    public recipe updateRecipe(recipe updatedRecipe) {
        Long recipeId = updatedRecipe.getId();

        recipe existingRecipe = recipeRepository.findById(recipeId).orElse(null);

        recipe recipeToUpdate = existingRecipe;
        recipeToUpdate.setTitle(updatedRecipe.getTitle());
        recipeToUpdate.setDescription(updatedRecipe.getDescription());
        recipeToUpdate.setIngredients(updatedRecipe.getIngredients());

        return recipeRepository.save(recipeToUpdate);
    }

    public void deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public void save(recipe recipe) {
        recipeRepository.save(recipe);
    }
    public List<recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}
