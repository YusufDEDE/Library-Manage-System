package TableModel;
import LibrarySystem.Faculty;


import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

public class FacultyTableModel extends AbstractTableModel {

    public final String[] columnNames = {"Member Id", "Type", "Name", "Adress", "Phone", "Date"};
    private LinkedList<Faculty> data;

    public FacultyTableModel(LinkedList<Faculty> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    public void addStudent(Faculty faculty) {
        int row = data.size();
        System.out.println(row);
        System.out.println(faculty);
        data.add(faculty);
        fireTableRowsInserted(row, row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Faculty faculty = data.get(rowIndex);
        if (faculty == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return faculty.getMemberId();
            case 1:
                return faculty.getType();
            case 2:
                return faculty.getName();
            case 3:
                return faculty.getAdress();
            case 4:
                return faculty.getPhoneNo();
            case 5:
                return faculty.getDateOfMembership();
            default:
                return null;
        }
    }
}