package fr.univtln.bruno.demos.jaxrs.resources;

import fr.univtln.bruno.demos.jaxrs.model.Person;
import fr.univtln.bruno.demos.jaxrs.model.PersonModel;
import fr.univtln.bruno.demos.jaxrs.model.ZooManager;
import fr.univtln.bruno.demos.jaxrs.model.animals.Animal;
import fr.univtln.bruno.demos.jaxrs.model.zoo.Zoo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Path("zoo")
public class ZooRessource {
    public  ZooManager zooManager =new ZooManager();

    @GET
    @Path("/all")
    public ZooManager get() {
        return (ZooManager) ZooManager.findALLAnimal();
    }




    @PUT
    @Path("/ajouter/{name}")
    public void put(String name) {
         zooManager.AjouterAnimal(name); ;
    }

}
