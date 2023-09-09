package pl.przepisy.Projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.przepisy.Projekt.repository.CommentRepository;

@Controller
@RequestMapping("/comment")
public class commentController {

@Autowired
private CommentRepository commentRepository;

//    @GetMapping("/list")
    }