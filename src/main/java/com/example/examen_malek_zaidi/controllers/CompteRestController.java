package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.Compte;
import com.example.examen_malek_zaidi.services.IcompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("compte")
public class CompteRestController {
    private final IcompteService icompteService;

    @PutMapping("/addcompte/{agenceBank}")
    public Compte ajouterCompteEtAffecterAAgence(@RequestBody Compte compte,@PathVariable("agenceBank")String agenceBank){
        return icompteService.ajouterCompteEtAffecterAAgence(compte, agenceBank);

    }

}
