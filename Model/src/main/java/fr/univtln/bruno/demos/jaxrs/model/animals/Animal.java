package fr.univtln.bruno.demos.jaxrs.model.animals;


import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import fr.univtln.bruno.demos.jaxrs.model.person.Personne;
import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Représnte un animal
 * @see fr.univtln.bruno.samples.entity.SimpleEntity
 * @author Liam
 * @author Haribou
 */
@Entity
//@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE_ENTITE")
@DiscriminatorValue("ANIMAL")
@Data
@CascadeOnDelete
@NoArgsConstructor
@AllArgsConstructor


@NamedQueries({
        @NamedQuery(name="animal.AllAninmal", query = "select animal from Animal animal"),
        @NamedQuery(name = "animal.FindAnimal",query = "select animal from Animal animal where animal.id=:id"),
        @NamedQuery(name = "animal.Findbyzoo",query = "select animal from Animal animal where animal.zoo=:zoo")
})
@MyAnnotation(name = "Animal")
@SuperBuilder
public class Animal implements SimpleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    private String name;

    private Boolean isDead = false;

    @ManyToOne
    private Zoo zoo;


    public Boolean Tue(Personne p){
        if(!p.getIsDead()){
            p.setIsDead(true);
            return true;
        }
        return false;
    }


    //////////////////////////////////////////////////
    /**
     *
     * @return Retourne le fr.univtln.bruno.demos.jaxrs.model.zoo de l'animal
     */
    public Zoo getManyToOne() {
        return zoo;
    }

    /**
     * Change le fr.univtln.bruno.demos.jaxrs.model.zoo de l'animal
     */
    public void setManyToOne(Zoo manyToOne) {
        this.zoo = manyToOne;
    }

    public static Animal FindAnimal(long id){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("animal.FindAnimal");
        query.setParameter("id",id);
        return (Animal) query.getSingleResult();
    }

    /**
     * Recherche les animaux appartenant au même fr.univtln.bruno.demos.jaxrs.model.zoo
     * @param zoo le fr.univtln.bruno.demos.jaxrs.model.zoo des animaux à renvoyer
     * @return liste des animaux du fr.univtln.bruno.demos.jaxrs.model.zoo
     */
    public static List FindAnimalInzoo(Zoo zoo){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("animal.Findbyzoo");
        query.setParameter("zoo",zoo);
        return  query.getResultList();
    }

}
