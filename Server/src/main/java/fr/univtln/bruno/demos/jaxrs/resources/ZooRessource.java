package fr.univtln.bruno.demos.jaxrs.resources;

import fr.univtln.bruno.demos.jaxrs.model.Person;
import fr.univtln.bruno.demos.jaxrs.model.PersonModel;
import fr.univtln.bruno.demos.jaxrs.model.ZooManager;
import fr.univtln.bruno.demos.jaxrs.model.animals.Aigle;
import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Path("zoos/")
public class ZooRessource {
    public  ZooManager zooManager =new ZooManager();

    @GET
    @Path("Animals")
    public List<Animal> get() {
        return  ZooManager.findALLAnimal();
    }
    @GET
    @Path("{id}")
    public Zoo get(@PathParam("id") int id) {
        return zooManager.getZoo(id);
    }

    @GET
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
    //curl -v --header "Content-Type: application/json" --request PUT --data '{"name":"hector"} "http://localhost:8080/myapp/zoos/Aigle"
    @POST
    @Path("Aigle")
    public void put(Aigle aigle) {
         zooManager.AjouterAigle(aigle); ;
    }

}
