package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.userRecipes;

public interface UsersRecipesRepository extends JpaRepository<userRecipes, Long> {
userRecipes save(userRecipes userRecipes);
    userRecipes getUserRecipesByRecipeId(Long id);

    userRecipes getUserRecipesByUserId(Long id);
}
