package pl.przepisy.Projekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.userRecipes;
import pl.przepisy.Projekt.repository.UsersRecipesRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserRecipesService {
    private final UsersRecipesRepository usersRecipesRepository;

    public void saveUserRecipes(userRecipes userRecipes) {
        usersRecipesRepository.save(userRecipes);
    }

    public void deleteUserRecipes(Long id) {
        usersRecipesRepository.deleteById(id);
    }

    public userRecipes getUserRecipesById(Long id) {
        return usersRecipesRepository.getOne(id);
    }

    public userRecipes updateUserRecipes(userRecipes updatedUserRecipes) {
        Long userRecipesId = updatedUserRecipes.getId();
        userRecipes existingUserRecipes = usersRecipesRepository.findById(userRecipesId).orElse(null);
        if (existingUserRecipes == null) {
            throw new IllegalArgumentException("UserRecipes with ID " + userRecipesId + " not found.");
        }
        userRecipes userRecipesToUpdate = existingUserRecipes;
        userRecipesToUpdate.setUser(updatedUserRecipes.getUser());
        userRecipesToUpdate.setRecipe(updatedUserRecipes.getRecipe());
        return usersRecipesRepository.save(userRecipesToUpdate);
    }

    public userRecipes getUserRecipesByRecipeId(Long id) {
        return usersRecipesRepository.getUserRecipesByRecipeId(id);
    }

    public userRecipes getUserRecipesByUserId(Long id) {
        return usersRecipesRepository.getUserRecipesByUserId(id);
    }

    public List<userRecipes> getAllUserRecipes() {
        return usersRecipesRepository.findAll();
    }

    public void saveUserRecipe(Long id, Long recipeId) {
    }
}
