package fr.moveo.applicationlourde.Views.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexMac on 13/05/15.
 */
public class Sheet extends JPanel {
    GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    JLabel jLabel[] = new JLabel[20];

    public Sheet() {
        setLayout(gridBagLayout);
        for (int i=0; i<20;i++){
            jLabel[i]=new JLabel("Label numéro"+i);
        }
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        add(jLabel[0], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(jLabel[1], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        add(jLabel[2], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        add(jLabel[3], gridBagConstraints);
        gridBagConstraints.gridx = 4;
        add(jLabel[4], gridBagConstraints);
        gridBagConstraints.gridx = 5;
        add(jLabel[5], gridBagConstraints);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 0;
        add(jLabel[6], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(jLabel[7], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        add(jLabel[8], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        add(jLabel[9], gridBagConstraints);
        gridBagConstraints.gridx = 4;
        add(jLabel[10], gridBagConstraints);
        gridBagConstraints.gridx = 5;
        add(jLabel[11], gridBagConstraints);
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridx = 0;
        add(jLabel[12], gridBagConstraints);
        gridBagConstraints.gridx = 1;
        add(jLabel[13], gridBagConstraints);
        gridBagConstraints.gridx = 2;
        add(jLabel[14], gridBagConstraints);
        gridBagConstraints.gridx = 3;
        add(jLabel[15], gridBagConstraints);
        gridBagConstraints.gridx = 4;
        add(jLabel[16], gridBagConstraints);
        gridBagConstraints.gridx = 5;
        add(jLabel[17], gridBagConstraints);
    }
}
