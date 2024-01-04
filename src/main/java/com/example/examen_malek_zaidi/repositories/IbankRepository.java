package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbankRepository extends JpaRepository<Bank,Long> {
Bank findByAgence(String agence);
}
