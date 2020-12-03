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

/**
 * Représnte une vache
 * @see fr.univtln.bruno.samples.animals.Animal
 * @author Liam
 * @author Haribou
 */
@Entity
@DiscriminatorValue("VACHE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@CascadeOnDelete
@SuperBuilder
public class Vache extends Animal{


    private int age;



    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;

}
