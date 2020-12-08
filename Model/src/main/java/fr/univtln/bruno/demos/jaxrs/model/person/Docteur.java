package fr.univtln.bruno.demos.jaxrs.model.person;


import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;

import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ZOOKEEPER")
@Data

@NoArgsConstructor
@AllArgsConstructor
@MyAnnotation(name = "Zookeeper")
@SuperBuilder
public class Docteur extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    private String nom;



 /*   @ManyToMany
    private List<Zoo> manyToMany;

    public List<Zoo> getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(List<Zoo> manyToMany) {
        this.manyToMany = manyToMany;
    }*/
}
