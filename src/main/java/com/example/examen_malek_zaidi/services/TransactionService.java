package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Compte;
import com.example.examen_malek_zaidi.entities.Transaction;
import com.example.examen_malek_zaidi.entities.TypeCompte;
import com.example.examen_malek_zaidi.entities.TypeTransaction;
import com.example.examen_malek_zaidi.repositories.IcompteRepository;
import com.example.examen_malek_zaidi.repositories.ItransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService implements ItransactionService {
    private final ItransactionRepository itransactionRepository;
    private final IcompteRepository compteRepository;

    @Override
    public String ajouterVirement(Transaction transaction) {
        if (transaction == null || transaction.getExpediteur() == null || transaction.getDestinataire() == null) {
            return "Transaction information is incomplete";
        }

        Compte expediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        Compte destinataire = compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

        if (expediteur == null || destinataire == null) {
            return "Compte expéditeur ou destinataire introuvable";
        }

        if (transaction.getType() == TypeTransaction.VIREMENT) {
            if (expediteur.getType() == TypeCompte.EPARGNE) {
                return "On ne peut pas faire un virement à partir d'un compte épargne";
            }

            double fraisTransaction = calculerFrais(transaction.getMontant());
            double montantTotal = transaction.getMontant() + fraisTransaction;

            if (expediteur.getSolde() < montantTotal + 3) {
                return "On ne peut pas faire un virement : Solde insuffisant";
            }

            // Génération de la date avant l'ajout de la transaction
            transaction.setDateTransaction(LocalDate.from(LocalDateTime.now()));

            // Mise à jour des soldes des comptes
            expediteur.setSolde(expediteur.getSolde() - montantTotal);
            destinataire.setSolde(destinataire.getSolde() + transaction.getMontant());

            // Ajout de la transaction à la base de données
            itransactionRepository.save(transaction);

            // Mise à jour des comptes dans la base de données
            compteRepository.save(expediteur);
            compteRepository.save(destinataire);

            return "VIREMENT de " + transaction.getMontant() + " DT de compte "
                    + expediteur.getIdCompte() + " vers le compte " + destinataire.getIdCompte()
                    + " approuvé avec succès.";
        }

        return "Type de transaction non pris en charge";
    }

    @Override
    public String ajouterRetrait(Transaction transaction) {
        if (transaction==null || transaction.getExpediteur()==null){
            return "Transaction information is incomplete";
        }
        Compte compte= compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        if (transaction.getType().equals(TypeTransaction.RETRAIT)){
            if (compte.getSolde() <(transaction.getMontant()+2)){
                return "Solde insuffisant";
            }

            transaction.setDateTransaction(LocalDate.now());
            compte.setSolde(compte.getSolde()-(transaction.getMontant()+2));
            itransactionRepository.save(transaction);
            compteRepository.save(compte);
            return "RETRAIT de "+transaction.getMontant()+" DT de compte "+compte.getIdCompte()+" approuvé avec succés!";
        }

        return "Type de transaction non pris en charge";
    }

    @Override
    public String ajouterVersement(Transaction transaction) {
       if (transaction==null || transaction.getExpediteur()==null || transaction.getDestinataire()==null){
           return "transaction incomplete";
       }
       Compte expediteur=compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
       Compte destinataire = compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

       if (transaction.getType().equals(TypeTransaction.VERSEMENT)){
            if (!destinataire.getType().equals(TypeCompte.EPARGNE)){
                transaction.setDateTransaction(LocalDate.now());
                expediteur.setSolde(expediteur.getSolde()- (transaction.getMontant()+2));
                destinataire.setSolde(destinataire.getSolde()+ (transaction.getMontant()-2));
                itransactionRepository.save(transaction);
                compteRepository.save(expediteur);
                compteRepository.save(destinataire);

              return  " VERSEMENT de " + (transaction.getMontant()-2) + " DT de compte "
                        + expediteur.getIdCompte() + " vers le compte " + destinataire.getIdCompte()
                        + " approuvé avec succès.";
            }


            transaction.setDateTransaction(LocalDate.now());
           expediteur.setSolde(expediteur.getSolde()- (transaction.getMontant()));
           destinataire.setSolde(destinataire.getSolde()+ (transaction.getMontant()));
           itransactionRepository.save(transaction);
           compteRepository.save(expediteur);
           compteRepository.save(destinataire);
           return  " VERSEMENT de " + transaction.getMontant() + " DT de compte "
                   + expediteur.getIdCompte() + " vers le compte " + destinataire.getIdCompte()
                   + " approuvé avec succès.";


       }
        return "Type de transaction non pris en charge";

    }


    @Scheduled(fixedRate = 30000)
    public void getAllTransactionByDate()
    {
        LocalDate e= LocalDate.now();
        List<Transaction> todayTransactions =itransactionRepository.findByDateTransaction(e);
    }

    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte){

    return (List<Transaction>)itransactionRepository.findByTypeAndExpediteur_IdCompteOrTypeAndDestinataire_IdCompte(type,idCompte,type,idCompte);

    }

    private double calculerFrais(double montant) {
        return 0.02 * montant; // Exemple : 2% du montant de la transaction
    }
}