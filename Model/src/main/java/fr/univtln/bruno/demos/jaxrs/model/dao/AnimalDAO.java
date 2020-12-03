package fr.univtln.bruno.demos.jaxrs.model.dao;

import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Couche d'accès au données des animaux
 * @see fr.univtln.bruno.samples.dao.DAO
 * @author Liam
 * @author Haribou
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class AnimalDAO extends AbstractDAO<Animal> {

    /**
     * méthode de recherche d'éléments de type Animal
     * à partir de leur nom
     * @param name le nom des animaux à trouver
     * @return La liste des animaux portant le nom name
     */
    public List findByName(String name) {
        return getEntityManager().createNamedQuery("animal.AllAninmal")
                .getResultList();
    }

    @Override
    public Class<Animal> getmytype() {
        return Animal.class;
    }
}
