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
public class WashingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private float price;
    @Enumerated(EnumType.STRING)
    private Type type;


   @ManyToMany(mappedBy = "washingServices")
    private Set<Reservation> reservations;

}
