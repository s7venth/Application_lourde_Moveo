package fr.moveo.applicationlourde.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * Created by alex on 16/07/15.
 */
public class TripTableModel  extends AbstractTableModel {
    private List<Trip> nbTrip ;
    private String[] columns ;

    public TripTableModel(List<Trip> tripList){
        super();
        nbTrip = tripList ;
        columns = new String[]{"id","nom_voyage", "pays_voyage","nb_commentaires"};
    }

    @Override
    public int getRowCount() {
        return nbTrip.size();
    }

    // Number of column of your table
    public int getColumnCount() {
        return columns.length ;
    }

    // The object to render in a cell
    public Object getValueAt(int row, int col) {
        Trip trip = nbTrip.get(row);
        switch(col) {
            case 0: return trip.getId();
            case 1: return trip.getName();
            case 2: return trip.getCountry();
            case 3: return trip.getCommentCount();
            default: return null;
        }
    }

    // Optional, the name of your column
    public String getColumnName(int col) {
        return columns[col] ;
    }

    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return col < 4;
    }

}
