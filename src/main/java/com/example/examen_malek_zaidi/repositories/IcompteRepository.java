package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcompteRepository extends JpaRepository<Compte,Long> {
}
