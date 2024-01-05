package com.example.examen_malek_zaidi.entities;

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
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;
    private String brand;
    private String immatriculation;
    @OneToMany(cascade = CascadeType.PERSIST)
    Set<Reservation> reservations;

}
