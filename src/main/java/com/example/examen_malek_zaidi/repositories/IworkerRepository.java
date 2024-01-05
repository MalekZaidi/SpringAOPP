package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IworkerRepository extends JpaRepository<Worker,Long> {
Worker findByNic(String nic);
}
// Worker findByAgence(String agence);