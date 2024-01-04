package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Bank;
import com.example.examen_malek_zaidi.repositories.IbankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankService implements IbankService{
    private final IbankRepository ibankRepository;
    @Override
    public Bank ajouterBank(Bank bank) {
        return ibankRepository.save(bank);
    }
}
