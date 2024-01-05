package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Reservation;
import com.example.examen_malek_zaidi.entities.Status;
import com.example.examen_malek_zaidi.entities.Vehicule;
import com.example.examen_malek_zaidi.entities.WashingService;
import com.example.examen_malek_zaidi.repositories.IvehiculeRepository;
import com.example.examen_malek_zaidi.repositories.IwashingServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IvehiculeService {

    private final IvehiculeRepository ivehiculeRepository;
    private final IwashingServiceRepository iwashingServiceRepository;

    @Override
    public Vehicule addVehiculeReservationAndAffectToWashingService(Vehicule vehicule, List<Long> idServices) {
        Reservation reservation = new Reservation();
        reservation.setStatus(Status.PENDING);
        reservation.setTimeReservation(LocalDateTime.now());

       /* Set<WashingService> washingServices = (Set<WashingService>) iwashingServiceRepository.findAllByIdServiceIn(idServices);
        reservation.setWashingServices(washingServices);*/

        vehicule.getReservations().add(reservation);

        ivehiculeRepository.save(vehicule);

        return vehicule;
    }
}
