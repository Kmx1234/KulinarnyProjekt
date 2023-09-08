package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@Entity
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @Range(min = 1, max = 5)
    private int score;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private recipe recipe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
}
