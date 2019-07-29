package TableModel;
import LibrarySystem.Transaction;
import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import java.util.Stack;

public class TransactionTableModel extends AbstractTableModel {

    public final String[] columnNames = {"Transaction ID", "Member ID", "Book ID", "Date Of Issue", "Due Date"};
    private LinkedList<Transaction> data;

    public TransactionTableModel(LinkedList<Transaction> data) {
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
        Transaction transaction = data.get(rowIndex);
        if (transaction == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return transaction.getTransactionId();
            case 1:
                return transaction.getMemberId();
            case 2:
                return transaction.getBookId();
            case 3:
                return transaction.getDateOfIssue();
            case 4:
                return transaction.getDueDate();
            default:
                return null;
        }
    }
}