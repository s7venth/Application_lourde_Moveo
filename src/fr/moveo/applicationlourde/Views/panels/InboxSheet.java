package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Message;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel that contains a table of message
 */
public class InboxSheet extends JPanel{
    ConnectMethods connectMethods = new ConnectMethods();

    public InboxSheet(ArrayList<Message> messageArrayList){
        JTable tableMessage = new JTable(connectMethods.getTableMessage(messageArrayList));
        this.add(new JScrollPane(tableMessage), BorderLayout.CENTER);
    }
}
