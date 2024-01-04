package com.example.examen_malek_zaidi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idBank;

    private String nom;
    private String agence;
    private String adresse;
    @JsonIgnore
    @OneToMany
    private Set<Compte> comptes;

}
