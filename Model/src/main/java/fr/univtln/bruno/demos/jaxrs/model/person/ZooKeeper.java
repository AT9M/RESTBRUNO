package fr.univtln.bruno.demos.jaxrs.model.person;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * Représnte un gardien de fr.univtln.bruno.demos.jaxrs.model.zoo
 * @author Liam
 * @author Haribou
 */
@Entity
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ZOOKEEPER")
@Data

@NoArgsConstructor
@AllArgsConstructor

@SuperBuilder
public class ZooKeeper extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
     long id;

     String nom;

}
