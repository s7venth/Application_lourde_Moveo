package fr.moveo.applicationlourde.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by alexandrequere on 20/07/2015.
 */
public class CommentTableModel extends AbstractTableModel{
    private List<Comment> nbComment;
    private String[] columns;

    public CommentTableModel(List<Comment> listComment) {
        super();
        nbComment = listComment;
        columns = new String[]{"Id utilisateur","Nom Utilisateur","Voyage Id","Message"};
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
            case 0: return comment.getUserId();
            case 1: return comment.getCommentUserLastName();
            case 2: return comment.getTripId();
            case 3: return comment.getCommentMessage();
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }
}
