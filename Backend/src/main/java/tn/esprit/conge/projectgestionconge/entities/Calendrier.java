package tn.esprit.conge.projectgestionconge.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Calendrier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

  String nom;
  Date disponibilite;

    @OneToMany(mappedBy = "calendrier", fetch = FetchType.LAZY)
    @JsonIgnore
    Set<User>users;

}
