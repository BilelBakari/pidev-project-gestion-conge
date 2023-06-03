package tn.esprit.conge.projectgestionconge.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Conge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    Integer soldAnnuel;

    Integer nbrJourPris;

    Integer nbrJourRestant;
    String etat;
    @Enumerated(EnumType.STRING)
    Type type;

    @OneToMany(mappedBy = "conge", fetch = FetchType.LAZY)
    @JsonIgnore
    Set<Demande> demandes;

}
