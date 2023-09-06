package pl.przepisy.Projekt.controller;

import jakarta.servlet.http.HttpServletRequest;
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
@RequiredArgsConstructor
public class userController {

private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new user());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid user user, BindingResult bindingResult, HttpServletRequest request) {
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
            request.getSession().setAttribute("user", user);
            return "redirect:/dashboard";
        } else {
            return "redirect:/User/login";
        }
    }
        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
        @GetMapping("/{id}")
    public ResponseEntity<user> getUserById(@PathVariable Long id) {
        user user = userService.findById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
        @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable Long id, @Valid @RequestBody user user) {
        user.setId(id);
        user updatedUser = userService.update(user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }
}