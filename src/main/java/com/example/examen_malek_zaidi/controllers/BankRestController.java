package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.Bank;
import com.example.examen_malek_zaidi.services.IbankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("bank")
public class BankRestController {

    private final IbankService ibankService;
    @PostMapping("/add")
    public Bank ajouterBank(@RequestBody Bank bank){
        return ibankService.ajouterBank(bank);

    }

}
