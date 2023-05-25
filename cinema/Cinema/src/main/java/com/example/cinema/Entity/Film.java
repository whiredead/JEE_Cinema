package com.example.cinema.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String realisateur;
    private Date dateSortie;
    private String photo;

    private double duree;

    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;

    @ManyToOne
    private Categorie categorie;
}
