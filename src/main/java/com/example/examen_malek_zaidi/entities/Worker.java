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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idWorker;

    private String name;
    private String nic;

    @OneToMany(mappedBy = "worker")
    private Set<Reservation> reservations;
}


