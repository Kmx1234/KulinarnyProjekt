package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.comment;

import java.util.List;


public interface CommentRepository extends JpaRepository<comment, Long> {
    comment save(comment comment);

    List<comment> findByRecipeId(Long recipeId);
}