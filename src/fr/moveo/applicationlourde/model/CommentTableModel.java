package fr.moveo.applicationlourde.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * the model class used to create a table of Comment
 */
public class CommentTableModel extends AbstractTableModel{
    private List<Comment> nbComment;
    private String[] columns;

    public CommentTableModel(List<Comment> listComment) {
        super();
        nbComment = listComment;
        columns = new String[]{"Message","Nom Utilisateur","Voyage Id"};
    }

    @Override
    public int getRowCount() {
        return nbComment.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Comment comment = nbComment.get(rowIndex);
        switch (columnIndex){
            case 0: return comment.getCommentMessage();
            case 1: return comment.getCommentUserLastName();
            case 2: return comment.getTripId();
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
