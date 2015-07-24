package fr.moveo.applicationlourde.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * the model class used to create a table of Message
 */
public class MessageTableModel extends AbstractTableModel{
    private List<Message> nbMessage;
    private String[] columns;

    public MessageTableModel(List<Message> listMessage) {
        super();
        nbMessage = listMessage;
        columns = new String[]{"nom utilisateur","prenom utilisateur", "Message", "date d'envoi"};
    }


    @Override
    public int getRowCount() {
        return nbMessage.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Message message = nbMessage.get(rowIndex);
        switch (columnIndex){
            case 0: return message.getLastname();
            case 1: return message.getFirstname();
            case 2: return message.getMessage();
            case 3: return message.getSentDateTime();
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }
}
