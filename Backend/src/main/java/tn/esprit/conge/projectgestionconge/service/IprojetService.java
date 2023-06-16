package tn.esprit.conge.projectgestionconge.service;


import tn.esprit.conge.projectgestionconge.entities.Conge;
import tn.esprit.conge.projectgestionconge.entities.Demande;

public interface IprojetService  {
    Demande ajouterDemande(Demande demande);

    Conge ajouterConge(Conge conge);




    Conge modifierNombreJoursPris(Conge conge, Integer nouveauNombreJours);

    Demande afficherDemande(Integer demandeId);

    void supprimerDemande(Integer demandeId);
}
