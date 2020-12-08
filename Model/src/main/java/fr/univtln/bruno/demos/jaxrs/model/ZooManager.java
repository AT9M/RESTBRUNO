package fr.univtln.bruno.demos.jaxrs.model;

import fr.univtln.bruno.demos.jaxrs.model.animals.Aigle;
import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.animals.Chien;
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
    private static Zoo zoo;

    static {
        properties.setProperty("test", "test");

        Zoo zoo1=Zoo.builder().name("Faron").build();
        zoo =zoo1;
        ZooKeeper zookeeper =ZooKeeper.builder().nom("John DOE").isDead(false).build();
        Aigle animal =Aigle.builder().name("eeeee").zoo(zoo1).build();


        try (HumainDAO humainDAO = HumainDAO.of()) {

            EntityTransaction transaction = humainDAO.getTransaction();

            transaction.begin();

            humainDAO.persist(zookeeper);


            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
        try (StructureDAO structureDAO = StructureDAO.of()) {

            EntityTransaction transaction = structureDAO.getTransaction();

            transaction.begin();

            structureDAO.persist(zoo1);

            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
      try (AnimalDAO animalDAO = AnimalDAO.of()) {

            EntityTransaction transaction = animalDAO.getTransaction();

            transaction.begin();

            animalDAO.persist(animal);


            transaction.commit();

        }catch (DataPersistException dataPersistException){
          System.out.println(dataPersistException.getMessage());
      }
    }




    public ZooManager() {
    }
    public Zoo getZoo(long id){
        return StructureDAO.of().find(id);
    }
    public Animal getAnimal(long id){
        return AnimalDAO.of().find(id);
    }
    public static List<Zoo> findALLZoo(){
        return Zoo.FindAllZoo();
    }

    public static List<Animal> findALLAnimal(){
        return  Animal.FindAnimal();
    }

    public void AjouterAigle(Aigle aigle){

        AjoutAnimalDB(aigle);
    }
    public  void AjouterChien(String name){

        AjoutAnimalDB(Chien.builder().name(name).build());
    }
    public void AjouterZooKeeper(ZooKeeper zooKeeper){
        AjoutPersonDB(zooKeeper);
    }

    public  void AjoutAnimalDB(Animal x){
        try (AnimalDAO animalDAO = AnimalDAO.of()) {

            EntityTransaction transaction = animalDAO.getTransaction();

            transaction.begin();

            animalDAO.persist(x);

            transaction.commit();

        }catch (DataPersistException dataPersistException){
            System.out.println(dataPersistException.getMessage());
        }
    }

    public  void AjoutPersonDB(Personne x){
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
