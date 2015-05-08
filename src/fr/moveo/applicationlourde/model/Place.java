package fr.moveo.applicationlourde.model;

import javax.swing.*;

/**
 * Created by alexMac on 08/05/15.
 * Classe model Lieu permettant d'utiliser les lieux.
 */

public class Place {
    int id;
    String name, address, description;

    public Place() {
    }

    public Place(int id, String name, String address) {
        this.name = name;
        this.address = address;
    }

    ImageIcon picture;
}
