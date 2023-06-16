package tn.esprit.conge.projectgestionconge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.conge.projectgestionconge.entities.Demande;

public interface DemandeRepository extends JpaRepository<Demande,Integer> {


}
