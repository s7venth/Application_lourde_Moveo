package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Comment;
import fr.moveo.applicationlourde.model.Trip;
import fr.moveo.applicationlourde.services.AbstractMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * panel that show all the comments
 * Created by alexMac on 13/05/15.
 */
public class CommentSheet extends JPanel {
    AbstractMethods abstractMethods = new AbstractMethods();

    /**
     * the constructor of the sheet
     * @param commentArrayList the arraylist of Comments
     */
    public CommentSheet(ArrayList<Comment> commentArrayList) {

        JTable tableau = new JTable(abstractMethods.getTableComment(commentArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
    }
}
