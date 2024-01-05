package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.Reservation;
import com.example.examen_malek_zaidi.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IreservationRepository extends JpaRepository<Reservation,Long> {
List<Reservation> findAllByStatusOrderByTimeReservation(Status status);
}
/*

  List<Reservation> findByDateTransaction(LocalDate date);

List<Reservation> findAllByStatusOrderByTimeReservation(Status status);


    List<Reservation> findByTypeAndExpediteur_IdCompteOrTypeAndDestinataire_IdCompte(Status type, long idCompteExpediteur, Status typeDestinataire, long idCompteDestinataire);
 */