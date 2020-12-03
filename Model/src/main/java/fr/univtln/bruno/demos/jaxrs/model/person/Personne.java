package fr.univtln.bruno.demos.jaxrs.model.person;

import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;

/**
 * Représnte une personne
 * @author Liam
 * @author Haribou
 */
@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("PERSONNE")
@Data
@CascadeOnDelete
@NoArgsConstructor
@AllArgsConstructor
@MyAnnotation(name = "Person")
@SuperBuilder
public class Personne implements SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private Boolean isDead = false;
}
