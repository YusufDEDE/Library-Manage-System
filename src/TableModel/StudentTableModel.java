package TableModel;
import LibrarySystem.Student;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

public class StudentTableModel extends AbstractTableModel {

    public final String[] columnNames = {"Member Id", "Type", "Name", "Adress", "Phone", "Date"};
    private LinkedList<Student> data;

    public StudentTableModel(LinkedList<Student> data) {
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

    public void addStudent(Student student) {
        int row = data.size();
        System.out.println(row);
        System.out.println(student);
        data.add(student);
        fireTableRowsInserted(row, row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = data.get(rowIndex);
        if (student == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return student.getMemberId();
            case 1:
                return student.getType();
            case 2:
                return student.getName();
            case 3:
                return student.getAdress();
            case 4:
                return student.getPhoneNo();
            case 5:
                return student.getDateOfMembership();
            default:
                return null;
        }
    }
}