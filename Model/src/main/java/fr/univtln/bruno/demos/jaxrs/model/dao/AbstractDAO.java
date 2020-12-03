package fr.univtln.bruno.demos.jaxrs.model.dao;

import fr.univtln.bruno.demos.jaxrs.model.ZooManager;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Getter
public abstract class  AbstractDAO<T extends SimpleEntity> implements DAO<T>{
    private EntityManager entityManager = Persistence
                                          .createEntityManagerFactory(ZooManager.properties.getProperty("test")).createEntityManager();

}
