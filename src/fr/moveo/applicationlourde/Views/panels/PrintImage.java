package fr.moveo.applicationlourde.Views.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sylvain on 11/04/15.
 */
public class  PrintImage extends JPanel {

    private Image img;
    private static final long serialVersionUID = 1L;

    public PrintImage(String s){
        // Permet de charger une image
        this.img = getToolkit().getImage(s);
    }

    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        //drawImage(Image img, int x, int y, int width, int height, Observer obs).
    }
}
