package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.przepisy.Projekt.entity.user;
import pl.przepisy.Projekt.repository.UserRepository;
import pl.przepisy.Projekt.service.UserService;
@Controller
@RequestMapping("/User")
public class userController {
@Autowired
private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new user());
        return "registration";
    }

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") @Valid user user, BindingResult bindingResult, HttpServletRequest request) {
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        userService.save(user);
//
//
//        return "redirect:/User/login";
//    }
@PostMapping("/register")
public String registerUser(@ModelAttribute("user") @Valid user user, BindingResult bindingResult, Model model) {
    if (userService.existsByLogin(user.getLogin())) {
        model.addAttribute("loginError", "Podany login już istnieje");
        return "registration";
    }

    if (bindingResult.hasErrors()) {

        return "registration";
    }

    userService.save(user);

    return "redirect:/User/login";
}
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, HttpServletRequest request) {
        user user = userService.findByLogin(login);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("userId", user.getId());
            request.getSession().setAttribute("user", user);
            System.out.println("Zalogowano użytkownika: " + user.getLogin());
            return "redirect:/dashboard";
        } else {
            return "redirect:/User/login";
        }
    }
}