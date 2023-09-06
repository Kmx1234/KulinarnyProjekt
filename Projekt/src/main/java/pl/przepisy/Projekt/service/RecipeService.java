package pl.przepisy.Projekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.repository.RecipeRepository;


@Service
@RequiredArgsConstructor
public class RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public recipe create(recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public recipe getRecipeById(Long id) {
        return recipeRepository.getOne(id);
    }

    public recipe updateRecipe(recipe updatedRecipe) {
        Long recipeId = updatedRecipe.getId();

        recipe existingRecipe = recipeRepository.findById(recipeId).orElse(null);
        if (existingRecipe == null) {
            throw new IllegalArgumentException("Recipe with ID " + recipeId + " not found.");
        }

        recipe recipeToUpdate = existingRecipe;
        recipeToUpdate.setTitle(updatedRecipe.getTitle());
        recipeToUpdate.setDescription(updatedRecipe.getDescription());
        recipeToUpdate.setScore(updatedRecipe.getScore());

        return recipeRepository.save(recipeToUpdate);
    }

    public recipe getRecipeByUserId(Long id) {
        return recipeRepository.getRecipeByUserId(id);
    }

    public recipe saveRecipe(recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void save(recipe recipe) {
        recipeRepository.save(recipe);
    }
}
