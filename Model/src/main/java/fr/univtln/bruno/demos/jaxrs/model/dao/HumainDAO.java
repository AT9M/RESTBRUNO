package fr.univtln.bruno.demos.jaxrs.model.dao;

import fr.univtln.bruno.demos.jaxrs.model.person.Personne;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Couche d'accès au données des personnes
 * @see
 * @author Liam
 * @author Haribou
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class HumainDAO extends AbstractDAO<Personne>{


    @Override
    public Class<Personne> getmytype() {
        return Personne.class;
    }
}
