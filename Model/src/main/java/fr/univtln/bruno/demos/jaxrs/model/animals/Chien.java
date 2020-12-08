package fr.univtln.bruno.demos.jaxrs.model.animals;

import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.maladies.Pathologie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.util.List;

/**
 * Représnte un chien
 * @see fr.univtln.bruno.demos.jaxrs.model.animals.Animal
 * @author Liam
 * @author Haribou
 */
@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@CascadeOnDelete

@NamedQuery(name="chien.DELETE", query = "SELECT chien FROM  Chien chien  where chien.name=:name")
@MyAnnotation(name = "Chien")
@SuperBuilder
public class Chien extends Animal {

    private int age;

    /**
     * @see Pathologie
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Pathologie> Pathos;




}
