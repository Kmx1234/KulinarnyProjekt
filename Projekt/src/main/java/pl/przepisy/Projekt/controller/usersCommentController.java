package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.przepisy.Projekt.entity.comment;
import pl.przepisy.Projekt.repository.CommentRepository;

import java.util.List;

@Controller
@RequestMapping("/usersComment")
public class usersCommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/list/{recipeId}")
    public String listRecipes(Model model, HttpSession session, @PathVariable Long recipeId) {
        List<comment> allComments = commentRepository.findByRecipeId(recipeId);
        model.addAttribute("allComments", allComments);
        return "comments"; // Zwraca widok, który wyświetla listę komentarzy
    }

}