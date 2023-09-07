package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users_recipes")
public class userRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private recipe recipe;
}
