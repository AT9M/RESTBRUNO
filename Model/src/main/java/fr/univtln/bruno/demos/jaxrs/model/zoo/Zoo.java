package fr.univtln.bruno.demos.jaxrs.model.zoo;

import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import fr.univtln.bruno.demos.jaxrs.model.person.Docteur;
import fr.univtln.bruno.demos.jaxrs.model.person.ZooKeeper;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@DiscriminatorValue("CHIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@CascadeOnDelete
@MyAnnotation(name = "Zoo")
public class Zoo implements SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    private String name;


    @OneToMany
    private List<ZooKeeper> ZOOKeeper;

    @ManyToMany
    private List<Docteur> manyToMany;

    public List<Docteur> getManyToMany() {
        return manyToMany;
    }

    public void setManyToMany(List<Docteur> manyToMany) {
        this.manyToMany = manyToMany;
    }


}