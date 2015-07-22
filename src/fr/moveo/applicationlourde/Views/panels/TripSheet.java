package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Trip;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class that contains the TripSheet
 */
public class TripSheet extends JPanel {
    ConnectMethods connectMethods = new ConnectMethods();

    /**
     * the constructor of this class
     * @param tripArrayList the ArrayList of the trips
     */
    public TripSheet(ArrayList<Trip> tripArrayList) {

        JTable tableau = new JTable(connectMethods.getTableTrip(tripArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
    }
}
