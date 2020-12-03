package fr.univtln.bruno.demos.jaxrs.model;

import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.dao.AnimalDAO;
import fr.univtln.bruno.demos.jaxrs.model.dao.HumainDAO;
import fr.univtln.bruno.demos.jaxrs.model.dao.StructureDAO;
import fr.univtln.bruno.demos.jaxrs.model.entity.SimpleEntity;
import fr.univtln.bruno.demos.jaxrs.model.exception.DataPersistException;
import fr.univtln.bruno.demos.jaxrs.model.person.Personne;
import fr.univtln.bruno.demos.jaxrs.model.person.ZooKeeper;
import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ZooManager {
    public static Properties properties = new Properties();

    static {
        properties.setProperty("test", "test");
    }

    private static final Zoo zoo=Zoo.builder().name("Faron").build();
    private static final ZooKeeper zookeeper =ZooKeeper.builder().id(1).nom("John DOE").build();
    public void init() {

        try (StructureDAO structureDAO = StructureDAO.of()) {

            EntityTransaction transaction = structureDAO.getTransaction();

            transaction.begin();

            structureDAO.persist(zoo);

            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
        try (HumainDAO humainDAO = HumainDAO.of()) {

            EntityTransaction transaction = humainDAO.getTransaction();

            transaction.begin();

            humainDAO.persist(zookeeper);


            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
    }

    public ZooManager() {
    }
    public static List<Animal> findALLAnimal(){
        return Animal.FindAnimalInzoo(zoo);
    }

    public void AjouterAnimal(String name){
        Animal animal = Animal.builder().name(name).zoo(zoo).build();
        AjoutAnimalDB(animal);
    }
    public void AjouterZooKeeper(String name){
        ZooKeeper zooKeeper = ZooKeeper.builder().nom(name).build();
        AjoutPersonDB(zooKeeper);
    }

    public void AjoutAnimalDB(Animal x){
        try (AnimalDAO animalDAO = AnimalDAO.of()) {

            EntityTransaction transaction = animalDAO.getTransaction();

            transaction.begin();

            animalDAO.persist(x);

            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
    }

    public void AjoutPersonDB(Personne x){
        try (HumainDAO humainDAO = HumainDAO.of()) {

            EntityTransaction transaction = humainDAO.getTransaction();

            transaction.begin();

            humainDAO.persist(x);

            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
    }

    //zOO
    //ANIMAL
    //ZookEERP


    //METHODES+FACTORY


    //fr.univtln.bruno.demos.jaxrs.model.zoo.findAll()

}
