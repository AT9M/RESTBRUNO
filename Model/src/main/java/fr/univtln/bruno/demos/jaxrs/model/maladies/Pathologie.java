package fr.univtln.bruno.demos.jaxrs.model.maladies;

import fr.univtln.bruno.demos.jaxrs.model.annotation.MyAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Représnte une pathologie
 * @author Liam
 * @author Haribou
 */
@Entity
@DiscriminatorValue("PATHOLOGIE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@MyAnnotation(name = "Pathologies")
@Builder
public class Pathologie {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    public Boolean CanKill(){
        if((name.equalsIgnoreCase("RAGE")==true) || (name.equalsIgnoreCase("Peste"))){
            return true;
        }
        else{
            return false;
        }
    }
}
