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
        columns = new String[]{};
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
