package com.example.examen_malek_zaidi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class Transaction {
    @Id
    @GeneratedValue
    private long idTransaction;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;

    @Temporal(TemporalType.DATE)
    private LocalDate dateTransaction;

    @ManyToOne
    private Compte destinataire;

    @ManyToOne
    private Compte expediteur;

}
