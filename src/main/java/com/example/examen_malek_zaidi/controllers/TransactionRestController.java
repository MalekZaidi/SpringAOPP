package com.example.examen_malek_zaidi.controllers;

import com.example.examen_malek_zaidi.entities.Transaction;
import com.example.examen_malek_zaidi.entities.TypeTransaction;
import com.example.examen_malek_zaidi.services.ItransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("transaction")
public class TransactionRestController {

    private final ItransactionService itransactionService;

    @PostMapping("/add")
    public String ajouterVirement(@RequestBody Transaction transaction) {
        return itransactionService.ajouterVirement(transaction);
    }

    @PostMapping ("/addRetrait")
    public String ajouterRetrait(@RequestBody Transaction transaction){
        return itransactionService.ajouterRetrait(transaction);

    }
    @PostMapping ("/addVersement")
    public String ajouterVersement(@RequestBody Transaction transaction){
        return itransactionService.ajouterVersement(transaction);

    }
    @GetMapping("/getTransactions/{type}/{idCompte}")
    public List<Transaction> getAllTransactionByTypeAndCompte(@PathVariable("type") TypeTransaction type, @PathVariable("idCompte") long idCompte){

      return itransactionService.getAllTransactionByTypeAndCompte(type,idCompte);

    }
}
