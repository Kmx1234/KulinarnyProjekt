package pl.przepisy.Projekt.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.przepisy.Projekt.entity.recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<recipe, Long> {
    List<recipe> getRecipeByUserId(Long id);

    void deleteById(Long id);

    recipe save(recipe recipe);


}
