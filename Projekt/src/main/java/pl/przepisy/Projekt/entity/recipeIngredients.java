package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredients")
public class recipeIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double quantity;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private recipe recipe;

    public void setIngredients(recipeIngredients ingredients) {
    }
}
