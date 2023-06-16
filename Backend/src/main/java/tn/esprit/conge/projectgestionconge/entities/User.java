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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    String nom;

    String prenom;

    String email;
    String mdp;
    Integer numtel;
    String fonction;

    @Enumerated(EnumType.STRING)
    Role role;
    @ManyToOne(fetch = FetchType.EAGER)
    Calendrier calendrier;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)

    @JsonIgnore
    Set<Demande> demandes;



}
