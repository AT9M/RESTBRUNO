package fr.univtln.bruno.demos.jaxrs.resources;

import fr.univtln.bruno.demos.jaxrs.model.ZooManager;

public class test {
    public static void main(String[] args) {
        ZooManager zooManager = new ZooManager();

        //zooManager.AjouterZooKeeper("zz");
        //zooManager.AjouterAigle("zzzzz");
        System.out.println(ZooManager.findALLZoo());
        System.out.println(ZooManager.findALLAnimal());
        System.out.println(zooManager.getZoo(1));
    }
}

