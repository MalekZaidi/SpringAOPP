package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.Vehicule;
import com.example.examen_malek_zaidi.services.IvehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Vehicule")
public class VehiculeRestController {
    private final IvehiculeService ivehiculeService;

    @PutMapping ("/addetAffecter/{idServices}")
    public Vehicule addVehiculeReservationAndAffectToWashingService(@RequestBody Vehicule vehicule,@PathVariable("idServices") List<Long> idServices)
        {
            return ivehiculeService.addVehiculeReservationAndAffectToWashingService(vehicule,idServices);
        }

}
