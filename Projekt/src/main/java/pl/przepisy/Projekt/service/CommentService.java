package pl.przepisy.Projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.comment;
import pl.przepisy.Projekt.repository.CommentRepository;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;



    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
public void save(comment comment){
        commentRepository.save(comment);
    }

}
