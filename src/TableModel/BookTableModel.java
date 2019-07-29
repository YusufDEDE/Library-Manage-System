package TableModel;
import LibrarySystem.Book;


import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

public class BookTableModel extends AbstractTableModel {

    public final String[] columnNames = {"Book Id", "Author", "Name", "Price", "Status"};
    private LinkedList<Book> data;

    public BookTableModel(LinkedList<Book> data) {
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


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = data.get(rowIndex);
        if (book == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return book.getBookId();
            case 1:
                return book.getAuthor();
            case 2:
                return book.getName();
            case 3:
                return book.getPrice();
            case 4:
                return book.getStatus();
            default:
                return null;
        }
    }
}