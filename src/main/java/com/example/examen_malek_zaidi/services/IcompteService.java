package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Compte;

public interface IcompteService {

    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
}
