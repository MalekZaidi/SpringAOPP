package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Vehicule;

import java.util.List;

public interface IvehiculeService {
public Vehicule addVehiculeReservationAndAffectToWashingService(Vehicule vehicule, List<Long> idService);
}

