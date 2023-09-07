package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.recipe;

public interface RecipeRepository extends JpaRepository<recipe, Long> {
    recipe getRecipeByUserId(Long id);


}