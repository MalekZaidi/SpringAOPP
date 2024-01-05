package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Worker;

import java.util.List;

public interface IworkerService {
    public Worker addWorker(Worker worker);
    public Worker affectWorkerToReservation(String nic, List<Long> idReservation);


}
/*
    Worker ajouterBank(Worker bank);

 */