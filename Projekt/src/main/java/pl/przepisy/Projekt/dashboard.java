package pl.przepisy.Projekt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboard {

    @GetMapping("/dashboard")
    public String hello() {
        return "dashboard";
    }

}
