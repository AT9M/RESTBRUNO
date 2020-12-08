package fr.univtln.bruno.demos.jaxrs.resources;

import fr.univtln.bruno.demos.jaxrs.model.Person;
import fr.univtln.bruno.demos.jaxrs.model.PersonModel;
import fr.univtln.bruno.demos.jaxrs.model.ZooManager;
import fr.univtln.bruno.demos.jaxrs.model.animals.Aigle;
import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.person.ZooKeeper;
import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Path("ZooManager/")
public class ZooRessource {
    public  ZooManager zooManager =new ZooManager();

    @GET
    @Path("Animals")
    public List<Animal> get() {
        return  ZooManager.findALLAnimal();
    }
    @GET
    @Path("zoo/{id}")
    public Zoo gets(@PathParam("id") int id) {
        return zooManager.getZoo(id);
    }
    @GET
    @Path("Animal/{id}")
    public Animal get(@PathParam("id") int id) {
        return zooManager.getAnimal(id);
    }
    @GET
    @Path("zoos")
    public List<Zoo> getzoo() {
        return ZooManager.findALLZoo();
    }


/*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
*/
// name: zoo:
    //curl -v --header "Content-Type: application/json" --request PÖST --data '{"name":"hector"} "http://localhost:8080/myapp/zoos/Aigle"
    //curl -v --data {"id":3,"manyToOne":{"ZOOKeeper":[],"id":1,"manyToMany":[],"name":"Faron"},"name":"eeeee","zoo":{"ZOOKeeper":[],"id":1,"manyToMany":[],"name":"Faron"},"age":0,
    //"pathos":[]} http://localhost:8080/myapp/zoos/Aigle
    //curl --data-urlencode "name=John Doe (Junior)" http://localhost:8080/myapp/ZooManager/Aigle
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Aigle")
    public void post(Aigle aigle) { zooManager.AjouterAigle(aigle); }

    @PUT
    @Path("ZooKeeper")
    public void put(ZooKeeper zooKeeper){zooManager.AjouterZooKeeper(zooKeeper);}

}
