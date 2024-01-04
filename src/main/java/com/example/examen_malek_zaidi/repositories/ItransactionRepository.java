package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.Transaction;
import com.example.examen_malek_zaidi.entities.TypeCompte;
import com.example.examen_malek_zaidi.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ItransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByDateTransaction(LocalDate date);




    List<Transaction> findByTypeAndExpediteur_IdCompteOrTypeAndDestinataire_IdCompte(TypeTransaction type, long idCompteExpediteur, TypeTransaction typeDestinataire, long idCompteDestinataire);
}
