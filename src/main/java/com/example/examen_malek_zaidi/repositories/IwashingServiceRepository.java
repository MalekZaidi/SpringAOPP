package com.example.examen_malek_zaidi.repositories;

import com.example.examen_malek_zaidi.entities.WashingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IwashingServiceRepository extends JpaRepository<WashingService,Long> {


    WashingService findAllByIdServiceIn(List <Long> idService);
}
