package fr.univtln.bruno.demos.jaxrs.resources;

import fr.univtln.bruno.demos.jaxrs.model.ZooManager;

public class test {
    public static void main(String[] args) {
        ZooManager zooManager = new ZooManager();
        zooManager.init();
        zooManager.AjouterZooKeeper("zz");
    }
}
