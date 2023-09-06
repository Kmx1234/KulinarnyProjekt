package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.recipeIngredients;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<recipeIngredients, Long> {
    public List<recipeIngredients> findByRecipeId(Long recipeId);
}
