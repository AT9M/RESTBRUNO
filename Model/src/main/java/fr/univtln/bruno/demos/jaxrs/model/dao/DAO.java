package fr.univtln.bruno.demos.jaxrs.model.dao;

import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import fr.univtln.bruno.demos.jaxrs.model.exception.DataPersistException;
import jakarta.validation.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * interface entre la base de données (couche d'accès aux données et
 * la couche métier: classe manipulant les données)
 * @author Liam
 * @author Haribou
 * @param <T>
 *     Classe de la couche métier
 */
public interface DAO<T extends SimpleEntity> extends AutoCloseable {

    Logger log = Logger.getLogger(DAO.class.getName());
    EntityManager getEntityManager();
    Class <T>  getmytype();

    /**
     * Rend persistante une nouvelle entité en l'enregistrant dans une base de données
     * @param E L'entité à faire persister
     * @return L'entité ou un clone de l'entité si l'identifiant à été mis à jour
     */
    default void persist(T E) throws DataPersistException { try {getEntityManager().persist(E);}catch (ConstraintViolationException e) {
        log.log(Level.SEVERE,"Exception: ");
        e.getConstraintViolations().forEach(err->log.log(Level.SEVERE,err.toString()));
        throw new DataPersistException(e.toString());
    } }

    default T merge(T animal) {
        return getEntityManager().merge(animal);
    }

    default void refresh(T animal) {
        getEntityManager().refresh(animal);
    }

    /**
     * Détache tous les éléments d'un persistance context (les entité ne sont plus gérée)
     *
     * Supprime les opérations (CRUD) faites sur les éléménts gérée à l'intérieur d'un persistance context
     */
    default void clear() {
        getEntityManager().clear();
    }

    /**
     * Méthode de recherche d'un élément de type Animal
     * à partir de son identifiant
     * @param id l'identifiant de l'entité
     * @return entité identifié par id
     */
    default T find(long id) { return getEntityManager().find(getmytype(), id); }

    @Override
    default void close() {
        getEntityManager().close();
    }

    default void flush() {
        getEntityManager().flush();
    }

    default EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }


}