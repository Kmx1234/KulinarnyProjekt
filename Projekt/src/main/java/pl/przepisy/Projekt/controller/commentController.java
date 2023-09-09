package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.przepisy.Projekt.entity.comment;
import pl.przepisy.Projekt.entity.recipe;
import pl.przepisy.Projekt.entity.user;
import pl.przepisy.Projekt.repository.CommentRepository;
import pl.przepisy.Projekt.service.RecipeService;

@Controller
@RequestMapping("/Comment")
public class commentController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/add/{recipeId}")
    public String addComment(Model model, @PathVariable Long recipeId) {
        recipe recipe = recipeService.getRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("comment", new comment());
        return "addComment";
    }
    @PostMapping("/add/{recipeId}")

    public String addComment(@Valid @ModelAttribute("comment") comment comment, BindingResult result,
                             @PathVariable Long recipeId, HttpSession session) {
        if (result.hasErrors()) {
            // Obsłuż błędy walidacji, jeśli są
            return "addComment";
        }

        user user = (user) session.getAttribute("user");
        // Pobierz przepis z serwisu lub repozytorium (w zależności od implementacji)
        recipe recipe = recipeService.getRecipeById(recipeId);

        // Ustaw przepis w komentarzu
        comment.setRecipe(recipe);

        // Zapisz komentarz
        comment.setUser(user);
        commentRepository.save(comment);

        return "redirect:/dashboard";
    }
}
//    @PostMapping("/add/{recipeId}")
//    public String addComment(@Valid @ModelAttribute("comment") comment comment, BindingResult result,
//                             @PathVariable Long recipeId) {
//        if (result.hasErrors()) {
//            // Obsłuż błędy walidacji, jeśli są
//            return "addComment";
//        }
//
//        recipe recipe = recipeService.getRecipeById(recipeId);
//        comment.setRecipe(recipe);
//        comment.setUser(recipe.getUser());
//        commentRepository.save(comment);
//        return "redirect:/dashboard";
//    }
//}



//    @GetMapping("/add/{recipeId}")
//    public String addComment(Model model, Long recipeId) {
//        recipe recipe = recipeService.getRecipeById(recipeId);
//        model.addAttribute("recipe", recipe);
//        model.addAttribute("comment", new comment());
//        return "addComment";
//    }
//
//    @PostMapping("/add/{recipeId}")
//    public String addComment(@Valid @ModelAttribute("recipe") recipe recipe, BindingResult result,
//                             HttpSession session) {
//        comment comment = (comment) session.getAttribute("comment");
//        comment.setRecipe(recipe);
//        commentRepository.save(comment);
//        return "redirect:/dashboard";
//    }
//}