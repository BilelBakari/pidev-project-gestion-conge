package tn.esprit.conge.projectgestionconge.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.conge.projectgestionconge.entities.Conge;
import tn.esprit.conge.projectgestionconge.entities.Demande;
import tn.esprit.conge.projectgestionconge.repository.CongeRepository;
import tn.esprit.conge.projectgestionconge.service.IprojetService;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProjetController {


    @Autowired
    IprojetService iprojetService;

    CongeRepository congeRepository;

    @Autowired
    public ProjetController(CongeRepository congeRepository) {
        this.congeRepository = congeRepository;
    }

    @PostMapping("/addDemande")
   public Demande ajouterDemande(@RequestBody Demande demande){
       return iprojetService.ajouterDemande(demande);
   }

   @PostMapping("/addConge")
    public Conge ajouterConge(@RequestBody Conge conge){
       return iprojetService.ajouterConge(conge);
   }
   @DeleteMapping("/supprimerDemande/{id}")
   public void supprimerDemande(@PathVariable("id") Integer id){
        iprojetService.supprimerDemande(id);
   }


  @GetMapping("/afficherDemande/{id}")
   public Demande afficherDemande(@PathVariable("id") Integer id){
        return iprojetService.afficherDemande(id);
  }






}
