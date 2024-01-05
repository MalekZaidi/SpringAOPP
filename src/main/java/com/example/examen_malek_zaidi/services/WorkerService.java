package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Reservation;
import com.example.examen_malek_zaidi.entities.Status;
import com.example.examen_malek_zaidi.entities.Worker;
import com.example.examen_malek_zaidi.repositories.IreservationRepository;
import com.example.examen_malek_zaidi.repositories.IworkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService implements IworkerService {
private final IworkerRepository iworkerRepository;
private final IreservationRepository ireservationRepository;
    @Override
    public Worker addWorker(Worker worker) {
        return iworkerRepository.save(worker);
    }

    public Worker affectWorkerToReservation(String nic, List<Long> idReservations) {
        Optional<Worker> optionalWorker = Optional.ofNullable(iworkerRepository.findByNic(nic));
        if (optionalWorker.isPresent()) {
            Worker worker = optionalWorker.get();
            if (worker.getReservations().size() + idReservations.size() <= 5) {
                for (Long id : idReservations) {
                    Optional<Reservation> optionalReservation = ireservationRepository.findById(id);
                    if (optionalReservation.isPresent()) {
                        Reservation reservation = optionalReservation.get();
                        reservation.setWorker(worker);
                        reservation.setStatus(Status.CONFIRMED);
                        ireservationRepository.save(reservation);
                    }
                }
                return worker;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
