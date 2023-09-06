package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private recipe recipe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne
    @JoinColumn(name = "rated_recipe_id")
    private recipe ratedRecipe;

    public comment(String content, recipe recipe, user user, recipe ratedRecipe) {
        this.content = content;
        this.recipe = recipe;
        this.user = user;
        this.ratedRecipe = ratedRecipe;
    }

    public double getScoreValue() {
        return ratedRecipe.getScore();
    }
}
