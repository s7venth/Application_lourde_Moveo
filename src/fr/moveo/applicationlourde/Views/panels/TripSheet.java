package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Trip;
import fr.moveo.applicationlourde.model.User;
import fr.moveo.applicationlourde.services.AbstractMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe qui permet d'afficher la fiche des voyages d'un utilisateur
 */
public class TripSheet extends JPanel {
    //VARIABLES
    Trip trip = new Trip();
    ArrayList<Trip> tripList= new ArrayList<Trip>();
    AbstractMethods abstractMethods = new AbstractMethods();

    //CONSTRUCTEUR
    public TripSheet(ArrayList<Trip> tripArrayList) {

        JTable tableau = new JTable(abstractMethods.getTableTrip(tripArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
    }


    //METHODES

}
