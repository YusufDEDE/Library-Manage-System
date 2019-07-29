import LibrarySystem.Main;
import TableModel.BookTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

public class UserView {

    public static Main ml = new Main();
    private static BookTableModel bookModel;
    private static JTable bookTable;

    public static void main(String args[]) {



        bookModel = new BookTableModel(ml.listBook());
        bookTable = new JTable(bookModel);

        JFrame frame = new JFrame("User Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(340, 160, 450, 300);

        JLabel UserWelcome = new JLabel(ml.loginWelcome(),SwingConstants.RIGHT);

        UserWelcome.setEnabled(false);
        UserWelcome.setForeground(Color.BLACK);
        UserWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));



        JButton btnBack = new JButton("Logout");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Library.main(new String[0]);
                frame.dispose();
            }
        });

        JLabel lblBookId = new JLabel("Book ID: ");
        JTextField txtBookId = new JTextField();
        txtBookId.setColumns(10);
        txtBookId.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });

        Random randomID = new Random();
        int TransactionID = randomID.nextInt(400)+600;
        int MemberID = ml.loginGetMemberId();
        JButton btnBookCheck = new JButton("Request Librarian!");
        btnBookCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int bookId = 0;
                bookId = Integer.parseInt(txtBookId.getText());

                if(ml.checkBookId(bookId) && ml.bookStatusCheck(bookId)){

                        JOptionPane.showMessageDialog(frame, "Book Id found... Successful Request!");
                        ml.addTransaction(TransactionID, MemberID, bookId, "", "");
                        txtBookId.setText("");
                        }


                else{
                    JOptionPane.showMessageDialog(frame, "Book Id not found or status false! ");
                    txtBookId.setText("");
                }
            }
        });
        JTabbedPane tabbedPane = new JTabbedPane();


        JPanel bookTransaction = new JPanel(new GridBagLayout());
        tabbedPane.addTab("Book Transaction",bookTransaction);

        GridBagConstraints addBookGBC = new GridBagConstraints();
        addBookGBC.insets = new Insets(2,2,2,2);

        // Add user label
        JLabel addBookTransLabel = new JLabel("Book Transaction");
        addBookTransLabel.setBounds(65,68,46,14);
        addBookTransLabel.setForeground(Color.GRAY);
        addBookTransLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));



        bookTable.setRowHeight(30);
        bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        bookTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        bookTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        bookTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        bookTable.getColumnModel().getColumn(4).setPreferredWidth(50);

        bookTable.setSize(100,200);
        bookTable.setEnabled(false);
        bookTable.setAutoscrolls(true);

        addBookGBC.anchor = GridBagConstraints.CENTER;
        addBookGBC.gridwidth = GridBagConstraints.REMAINDER;
        bookTransaction.add(addBookTransLabel, addBookGBC);

        bookTransaction.add(bookTable.getTableHeader(), addBookGBC);
        bookTransaction.add(bookTable,addBookGBC);

        addBookGBC.anchor = GridBagConstraints.EAST;
        addBookGBC.gridwidth = GridBagConstraints.RELATIVE;
        bookTransaction.add(lblBookId, addBookGBC);
        addBookGBC.anchor = GridBagConstraints.WEST;
        addBookGBC.gridwidth = GridBagConstraints.REMAINDER;
        bookTransaction.add(txtBookId,addBookGBC);

        addBookGBC.anchor = GridBagConstraints.CENTER;
        addBookGBC.gridwidth = GridBagConstraints.REMAINDER;
        bookTransaction.add(btnBookCheck, addBookGBC);

        frame.add(btnBack, BorderLayout.SOUTH);
        frame.add(UserWelcome, BorderLayout.NORTH);
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(750, 500);
        frame.setVisible(true);
    }
}