package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class userRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private pl.przepisy.Projekt.entity.user user;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private pl.przepisy.Projekt.entity.recipe recipe;
}
