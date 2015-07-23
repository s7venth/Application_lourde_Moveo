package fr.moveo.applicationlourde.Views.panels;

import fr.moveo.applicationlourde.model.Comment;
import fr.moveo.applicationlourde.services.ConnectMethods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * panel that show all the comments
 */
public class CommentSheet extends JPanel {
    ConnectMethods connectMethods = new ConnectMethods();

    /**
     * the constructor of the sheet
     * @param commentArrayList the arraylist of Comments
     */
    public CommentSheet(ArrayList<Comment> commentArrayList) {

        JTable tableau = new JTable(connectMethods.getTableComment(commentArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
    }
}
