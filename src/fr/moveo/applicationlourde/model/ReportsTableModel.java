package fr.moveo.applicationlourde.model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * the model class used to create a table of reports
 */
public class ReportsTableModel extends AbstractTableModel{
    private List<Reports> nbReports;
    private String[] columns;

    public ReportsTableModel(List<Reports> listReports) {
        super();
        nbReports = listReports;
        columns = new String[]{"identifiant utilisateur","identifiant photo","Suppression"};
    }

    @Override
    public int getRowCount() {
        return nbReports.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reports reports = nbReports.get(rowIndex);
        switch (columnIndex){
            case 0: return reports.getIdUser();
            case 1: return reports.getIdPicture();
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(getValueAt(0, columnIndex) instanceof JButton)
            return false;
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
