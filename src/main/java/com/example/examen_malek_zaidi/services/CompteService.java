package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Bank;
import com.example.examen_malek_zaidi.entities.Compte;
import com.example.examen_malek_zaidi.repositories.IbankRepository;
import com.example.examen_malek_zaidi.repositories.IcompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompteService implements IcompteService{
    private final IbankRepository ibankRepository;
    private final IcompteRepository icompteRepository;

    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        Bank b=ibankRepository.findByAgence(agenceBank);
        Set<Compte>comptes=b.getComptes();
        comptes.add(compte);
        b.setComptes(comptes);
        return icompteRepository.save(compte);
    }
}
