package fr.univtln.bruno.demos.jaxrs.model.zoo;

import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import fr.univtln.bruno.demos.jaxrs.model.person.Docteur;
import fr.univtln.bruno.demos.jaxrs.model.person.ZooKeeper;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@CascadeOnDelete
@MyAnnotation(name = "Zoo")
@NamedQueries({
        @NamedQuery(name="zoo.AllZoo", query = "select zoo from Zoo zoo"),
        @NamedQuery(name = "zoo.FindZoo",query = "select zoo from Zoo zoo where zoo.id=:id")
})
public class Zoo implements SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    private String name;


    @OneToMany
    private List<ZooKeeper> ZOOKeeper;

   /* @ManyToMany
    private List<Docteur> manyToMany;

    public List<Docteur> getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(List<Docteur> manyToMany) {
        this.manyToMany = manyToMany;
    }*/

    public static List<Zoo> FindAllZoo(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("zoo.AllZoo");
        return (List<Zoo>) query.getResultList();
    }
    /*public static Zoo FindZoo(long id){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("zoo.FindZoo");
        return (List<Zoo>) query.getResultList();
    }*/
}