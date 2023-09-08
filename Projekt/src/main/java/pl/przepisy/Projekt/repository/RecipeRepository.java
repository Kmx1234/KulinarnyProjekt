package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<recipe, Long> {
    List<recipe> getRecipeByUserId(Long id);

    void deleteById(Long id);

    recipe save(recipe recipe);


}
