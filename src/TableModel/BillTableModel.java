package TableModel;
import LibrarySystem.Bill;


import javax.swing.table.AbstractTableModel;
import java.util.Stack;

public class BillTableModel extends AbstractTableModel {

    public final String[] columnNames = {"Bill No", "Member Id", "Amount", "Date"};
    private Stack<Bill> data;

    public BillTableModel(Stack<Bill> data) {
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
        Bill bill = data.get(rowIndex);
        if (bill == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return bill.getBillNo();
            case 1:
                return bill.getMemberId();
            case 2:
                return bill.getAmount();
            case 3:
                return bill.getDate();
            default:
                return null;

        }
    }
}