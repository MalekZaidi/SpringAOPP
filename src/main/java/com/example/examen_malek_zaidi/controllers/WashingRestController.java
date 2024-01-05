package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.WashingService;
import com.example.examen_malek_zaidi.services.iwachingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("washing")
public class WashingRestController {
private final iwachingService  iwachingService;
    @PostMapping("/add")
    public void addWashingService(@RequestBody List<WashingService> washingServices){
        iwachingService.addWashingService(washingServices);
    }


}
/*
    private final IReservationService itransactionService;

    @PostMapping("/add")
    public String ajouterVirement(@RequestBody Reservation transaction) {
        return itransactionService.ajouterVirement(transaction);
    }

    @PostMapping ("/addRetrait")
    public String ajouterRetrait(@RequestBody Reservation transaction){
        return itransactionService.ajouterRetrait(transaction);

    }
    @PostMapping ("/addVersement")
    public String ajouterVersement(@RequestBody Reservation transaction){
        return itransactionService.ajouterVersement(transaction);

    }
    @GetMapping("/getTransactions/{type}/{idCompte}")
    public List<Reservation> getAllTransactionByTypeAndCompte(@PathVariable("type") Status type, @PathVariable("idCompte") long idCompte){

      return itransactionService.getAllTransactionByTypeAndCompte(type,idCompte);

    }*

 */





