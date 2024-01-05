package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.Worker;
import com.example.examen_malek_zaidi.services.IworkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("worker")
public class WorkerRestController {
    private final IworkerService iworkerService;
    @PostMapping("/add")
    public Worker addWorker(@RequestBody Worker worker){
        return iworkerService.addWorker(worker);

}
  @PutMapping("/Affecter/{nic}/{idReservations}")
  public Worker affectWorkerToReservation(@PathVariable("nic") String nic, @PathVariable("idReservations") List<Long> idReservations){

        return iworkerService.affectWorkerToReservation(nic,idReservations);

  }
}
