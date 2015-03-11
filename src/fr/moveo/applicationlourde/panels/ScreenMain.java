package fr.moveo.applicationlourde.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sylvain on 11/03/15.
 */
public class ScreenMain extends JPanel{
    JButton button;
    Image image;

    public ScreenMain(){
        button = new JButton("cliquer ici");
        this.add(button);

    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}