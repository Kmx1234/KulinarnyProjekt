package pl.przepisy.Projekt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
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
    @NotNull
    private String ingredients;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<comment> comments = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
}