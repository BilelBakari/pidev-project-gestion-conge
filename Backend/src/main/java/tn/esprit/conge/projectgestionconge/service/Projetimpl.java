package tn.esprit.conge.projectgestionconge.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.conge.projectgestionconge.entities.Conge;
import tn.esprit.conge.projectgestionconge.entities.Demande;
import tn.esprit.conge.projectgestionconge.repository.CongeRepository;
import tn.esprit.conge.projectgestionconge.repository.DemandeRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class Projetimpl implements IprojetService {

     CongeRepository congeRepository;
     DemandeRepository demandeRepository;

     @Override
     public Demande ajouterDemande(Demande demande){return demandeRepository.save(demande);}


    @Override
    public Conge ajouterConge(Conge conge){return congeRepository.save(conge);}

    @Override
    public Conge modifierNombreJoursPris(Conge conge, Integer nouveauNombreJours) {

       Optional<Demande> congéExist = demandeRepository.findById(conge.getId());
        if (congéExist.isPresent()) {
            Conge congéExistant = congéExist.get().getConge();

            // Modifier le nombre de jours restants
            congéExistant.setNbrJourPris(nouveauNombreJours);

            // Enregistrer les modifications dans la base de données
            return congeRepository.save(congéExistant);
        } else {
            // Le congé n'existe pas, vous pouvez lever une exception ou retourner null selon vos besoins.
            throw new RuntimeException("Congé introuvable");
        }
    }

    @Override
    public Demande afficherDemande(Integer demandeId) {
        // Vérifier si la demande existe
        Optional<Demande> demandeExistante = demandeRepository.findById(demandeId);
        if (demandeExistante.isPresent()) {
            Demande demande = demandeExistante.get();

            // Afficher les informations de la demande
            System.out.println("ID de la demande : " + demande.getId());
            System.out.println("Date de début : " + demande.getDateDebut());
            System.out.println("Date de fin : " + demande.getDateFin());
            // Répéter pour les autres propriétés de la demande...

            return demande;
        } else {
            // La demande n'existe pas, vous pouvez lever une exception ou effectuer une autre action selon vos besoins.
            throw new RuntimeException("Demande introuvable");
        }
}

    @Override
    public void supprimerDemande(Integer demandeId) {

        Optional<Demande> demandeExistante = demandeRepository.findById(demandeId);
        if (demandeExistante.isPresent()) {
            Demande demande = demandeExistante.get();

            // Supprimer la demande de la base de données
            demandeRepository.delete(demande);
        } else {
            // La demande n'existe pas, vous pouvez lever une exception ou effectuer une autre action selon vos besoins.
            throw new RuntimeException("Demande introuvable");
        }
    }



}
