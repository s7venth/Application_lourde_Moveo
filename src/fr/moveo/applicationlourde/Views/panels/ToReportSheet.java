package fr.moveo.applicationlourde.Views.panels;

import com.sun.codemodel.internal.JOp;
import fr.moveo.applicationlourde.model.Reports;
import fr.moveo.applicationlourde.services.ConnectMethods;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Jpanel that contains a table of reports
 */
public class ToReportSheet extends JPanel {
    ConnectMethods connectMethods = new ConnectMethods();

    /**
     * the constructor of this class
     * @param ReportsArrayList the arraylist used in the table
     */
    public ToReportSheet(ArrayList<Reports> ReportsArrayList) {

        JTable tableau = new JTable(connectMethods.getTableReport(ReportsArrayList));

        this.add(new JScrollPane(tableau), BorderLayout.CENTER);
        tableau.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable source = (JTable)e.getSource();
                Point point = e.getPoint();
                int row,column;
                row 	= source.rowAtPoint(point);
                column 	= source.columnAtPoint(point);
                StringBuffer response = connectMethods.deletePhoto(source.getValueAt(row,column).toString());
                JSONObject jsonObject = new JSONObject(response.toString());
                JFrame jFrame = new JFrame();
                if (jsonObject.getInt("success")==1){
                    JOptionPane.showMessageDialog(jFrame,"la photo a bien été supprimée","Suppression reussi",JOptionPane.INFORMATION_MESSAGE);
                } else if (jsonObject.getInt("error")==1){
                    JOptionPane.showMessageDialog(jFrame,jsonObject.getString("message"),"Oups",JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
