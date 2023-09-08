package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.comment;
import pl.przepisy.Projekt.entity.recipe;

import java.util.List;


public interface CommentRepository extends JpaRepository<comment, Long> {
    comment getCommentByRecipeId(Long id);

    comment getCommentByUserId(Long id);

//    List<comment> findByRatedRecipe(recipe recipe);
}
