package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class logoutController {
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Zakończ sesję użytkownika
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Opcjonalnie, możesz przekierować użytkownika na stronę główną lub inną stronę po wylogowaniu.
        return "redirect:/home"; // Zmodyfikuj ścieżkę przekierowania według własnych potrzeb.
    }
}

