package fr.univtln.bruno.demos.jaxrs.model.animals;


import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.maladies.Pathologie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("AIGLE")
@Data
@CascadeOnDelete
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MyAnnotation(name = "Aigle")
public class Aigle extends Animal {

    private int age;

    /**
     * @see Pathologie
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;


}
