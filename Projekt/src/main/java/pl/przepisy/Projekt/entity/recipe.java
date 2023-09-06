package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Data
@Entity
public class recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @Range(min = 1, max = 5)
    private Double score;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<comment> comments;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

}