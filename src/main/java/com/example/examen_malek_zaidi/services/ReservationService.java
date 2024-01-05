package com.example.examen_malek_zaidi.services;

import com.example.examen_malek_zaidi.entities.Reservation;
import com.example.examen_malek_zaidi.entities.Status;
import com.example.examen_malek_zaidi.repositories.IreservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final IreservationRepository ireservationRepository;

    @Override
    @Scheduled(fixedRate = 15000)
    public void getReservation() {
   ireservationRepository.findAllByStatusOrderByTimeReservation(Status.PENDING);
        // repo List<Reservation> findAllByStatusOrderByTimeReservation(Status status);

    }

}
 /*   private final IreservationRepository itransactionRepository;
    private final IvehiculeRepository compteRepository;

    @Override
    public String ajouterVirement(Reservation transaction) {
        if (transaction == null || transaction.getExpediteur() == null || transaction.getDestinataire() == null) {
            return "Reservation information is incomplete";
        }

        Vehicule expediteur = compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        Vehicule destinataire = compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

        if (expediteur == null || destinataire == null) {
            return "Vehicule expéditeur ou destinataire introuvable";
        }

        if (transaction.getType() == Status.VIREMENT) {
            if (expediteur.getType() == Type.EPARGNE) {
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
    public String ajouterRetrait(Reservation transaction) {
        if (transaction==null || transaction.getExpediteur()==null){
            return "Reservation information is incomplete";
        }
        Vehicule compte= compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
        if (transaction.getType().equals(Status.RETRAIT)){
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
    public String ajouterVersement(Reservation transaction) {
       if (transaction==null || transaction.getExpediteur()==null || transaction.getDestinataire()==null){
           return "transaction incomplete";
       }
       Vehicule expediteur=compteRepository.findById(transaction.getExpediteur().getIdCompte()).orElse(null);
       Vehicule destinataire = compteRepository.findById(transaction.getDestinataire().getIdCompte()).orElse(null);

       if (transaction.getType().equals(Status.VERSEMENT)){
            if (!destinataire.getType().equals(Type.EPARGNE)){
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
        List<Reservation> todayTransactions =itransactionRepository.findByDateTransaction(e);
    }

    public List<Reservation> getAllTransactionByTypeAndCompte(Status type, long idCompte){

    return (List<Reservation>)itransactionRepository.findByTypeAndExpediteur_IdCompteOrTypeAndDestinataire_IdCompte(type,idCompte,type,idCompte);

    }

    private double calculerFrais(double montant) {
        return 0.02 * montant; // Exemple : 2% du montant de la transaction
    }*/