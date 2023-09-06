//package pl.przepisy.Projekt.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import pl.przepisy.Projekt.entity.comment;
//import pl.przepisy.Projekt.entity.recipe;
//import pl.przepisy.Projekt.service.CommentService;
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/comments")
//public class commentController {
//    private final CommentService commentService;
//
//
//    // Endpoint do dodawania nowego komentarza
//    @PostMapping
//    public ResponseEntity<comment> addComment(@RequestBody comment comment) {
//        commentService.saveComment(comment);
//        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
//    }
//
//    // Endpoint do pobierania komentarza po jego ID
//    @GetMapping("/{id}")
//    public ResponseEntity<comment> getCommentById(@PathVariable Long id) {
//        comment comment = commentService.getCommentByUserId(id);
//        if (comment != null) {
//            return ResponseEntity.ok(comment);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // Endpoint do aktualizacji komentarza
//    @PutMapping("/{id}")
//    public ResponseEntity<comment> updateComment(@PathVariable Long id, @RequestBody comment updatedComment) {
//       comment existingComment = commentService.updateComment(updatedComment);
//        if (existingComment == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        existingComment.setContent(updatedComment.getContent());
//        existingComment.setRecipe(updatedComment.getRecipe());
//        existingComment.setUser(updatedComment.getUser());
//        commentService.updateComment(existingComment);
//
//        return ResponseEntity.ok(existingComment);
//    }
//
//    // Endpoint do usuwania komentarza po jego ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
//        comment comment = commentService.deleteComment(id);
//        if (comment != null) {
//            commentService.deleteComment(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    // Endpoint do obliczania średniej oceny przepisu
//    @GetMapping("/recipe/{recipeId}/average-rating")
//    public ResponseEntity<Double> calculateAverageRatingForRecipe(@PathVariable Long recipeId) {
//        recipe recipe = new recipe(); // Stworzenie obiektu przepisu, który zostanie przekazany do serwisu
//        recipe.setId(recipeId);
//
//        double averageRating = commentService.calculateAverageRatingForRecipe(recipe);
//        return ResponseEntity.ok(averageRating);
//    }
//
//    // Dodaj dodatkowe endpointy w zależności od potrzeb Twojej aplikacji.
//}
