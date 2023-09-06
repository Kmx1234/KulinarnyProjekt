package pl.przepisy.Projekt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.przepisy.Projekt.entity.comment;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.repository.CommentRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveComment(comment comment) {
        commentRepository.save(comment);
    }

    public comment deleteComment(Long id) {
        commentRepository.deleteById(id);
        return null;
    }

    public comment updateComment(comment updateComment){
        String commentId = String.valueOf(updateComment.getId());

        comment existingComment = commentRepository.findById(Long.valueOf(commentId)).orElse(null);
        if (existingComment == null) {
            throw new IllegalArgumentException("Comment with ID " + commentId + " not found.");
        }
        comment commentToUpdate = existingComment;
        commentToUpdate.setContent(updateComment.getContent());
        commentToUpdate.setRecipe(updateComment.getRecipe());
        commentToUpdate.setUser(updateComment.getUser());
        commentRepository.save(commentToUpdate);
        return commentToUpdate;
    }

    public comment getCommentByRecipeId(Long id) {
        return commentRepository.getCommentByRecipeId(id);
    }

    public comment getCommentByUserId(Long id) {
        return commentRepository.getCommentByUserId(id);
    }

    public double calculateAverageRatingForRecipe(recipe recipe) {
        List<comment> commentsForRecipe = commentRepository.findByRatedRecipe(recipe);
        if (commentsForRecipe.isEmpty()) {
            return 0.0; // Brak komentarzy, średnia ocena wynosi 0.
        }

        double totalRating = 0;
        for (comment comment : commentsForRecipe) {
            totalRating += comment.getScoreValue();
        }

        return totalRating / commentsForRecipe.size();
    }


}
