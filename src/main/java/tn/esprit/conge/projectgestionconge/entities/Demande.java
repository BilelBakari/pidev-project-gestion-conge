package tn.esprit.conge.projectgestionconge.entities;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    Date dateDemande;

    Date dateDebut;

    Date     dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    User user;
    @ManyToOne(fetch = FetchType.EAGER)
    Conge conge;





}
