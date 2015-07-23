package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Reports;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Jpanel that contains a table of reports
 */
public class ToReportSheet extends JPanel{
    ConnectMethods connectMethods = new ConnectMethods();

    /**
     * the constructor of this class
     * @param ReportsArrayList the arraylist used in the table
     */
    public ToReportSheet(ArrayList<Reports> ReportsArrayList) {

        JTable tableau = new JTable(connectMethods.getTableReport(ReportsArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);

    }
}
