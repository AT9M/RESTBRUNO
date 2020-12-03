package fr.univtln.bruno.demos.jaxrs.model.dao;

import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Couche d'accès au données des zoos
 * @see fr.univtln.bruno.samples.dao.DAO
 * @author Liam
 * @author Haribou
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(staticName = "of")
public class StructureDAO extends AbstractDAO<Zoo> {
    @Override
    public Class<Zoo> getmytype() {
        return Zoo.class;
    }
}
