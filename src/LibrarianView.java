import LibrarySystem.Main;
import TableModel.*;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.*;


public class LibrarianView extends Library{


    public static Main ml = Main.getInstance();
    private static StudentTableModel studentModel;
    private static FacultyTableModel facultyModel;
    private static BookTableModel bookModel;
    private static TransactionTableModel transactionTableModel;
    private static BillTableModel billTableModel;


    private static JTable memberTable ;
    private static JTable facultyTable;
    private static JTable bookTable;
    private static JTable transactionTable;
    private static JTable returnBookTable;
    private static JTable billTable;

    private static String Date =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    public static void main(String args[]) {

        EventQueue.invokeLater(() -> {
            try {
                studentModel = new StudentTableModel(ml.listStudent());
                bookModel = new BookTableModel(ml.listBook());
                transactionTableModel = new TransactionTableModel(ml.listTransaction());
                facultyModel = new FacultyTableModel(ml.listFaculty());
                billTableModel = new BillTableModel(ml.listBill());

                memberTable = new JTable(studentModel);
                facultyTable = new JTable(facultyModel);
                bookTable = new JTable(bookModel);
                transactionTable = new JTable(transactionTableModel);
                returnBookTable = new JTable(transactionTableModel);
                billTable = new JTable(billTableModel);


            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        JFrame frame = new JFrame("Librarian Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(340, 160, 450, 300);
        JButton btnBack = new JButton("Logout");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Library.main(new String[0]);
                frame.dispose();
            }
        });

        JTabbedPane tabbedPane = new JTabbedPane();

        /* Add User section begin */
        JPanel addUser = new JPanel(new GridBagLayout());
        tabbedPane.addTab("User Transaction",addUser);
        GridBagConstraints addUserGBC = new GridBagConstraints();
        addUserGBC.insets = new Insets(2,2,2,2);

        // Add user label
        JLabel addUserTransLabel = new JLabel("User Transaction");
        addUserTransLabel.setBounds(65,68,46,14);
        addUserTransLabel.setForeground(Color.GRAY);
        addUserTransLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblMemberId = new JLabel("Member ID:");
        JTextField txtMemberId = new JTextField();
        txtMemberId.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        txtMemberId.setColumns(30);

        JRadioButton Student, Faculty;
        Student = new JRadioButton("Student",false);
        Faculty = new JRadioButton("Faculty",false);


        ButtonGroup memberType = new ButtonGroup();
        memberType.add(Student);
        memberType.add(Faculty);

        JLabel lblUserName = new JLabel("User Name-Surname:");
        JTextField txtUserName = new JTextField();
        txtUserName.setColumns(30);

        JLabel lblUserAdress = new JLabel("User Adress:");
        JTextField txtUserAdress = new JTextField();
        txtUserAdress.setColumns(30);

        JLabel lblUserPhone = new JLabel("User Phone");
        JTextField txtUserPhone = new JTextField();
        txtUserPhone.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        txtUserPhone.setColumns(30);

        JOptionPane.showMessageDialog(frame, "Successful Login!");


        JButton addMember = new JButton("Add User");
        int MemberId;
        String MemberType;
        String date;
        String adress;
        String phone;
        addMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int MemberId;
                String date;
                String name;
                String adress;
                String phone;

                if (txtMemberId.getText().isEmpty() || txtUserName.getText().isEmpty() ||
                        txtUserAdress.getText().isEmpty() || txtUserPhone.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "No empty information!","Error",JOptionPane.ERROR_MESSAGE);
                    Student.setSelected(false);
                    Faculty.setSelected(false);
                    txtMemberId.setText("");
                    txtUserName.setText("");
                    txtUserAdress.setText("");
                    txtUserPhone.setText("");
                }
                else{
                    if(Student.isSelected() || Faculty.isSelected()){
                        if(Student.isSelected()){
                            JOptionPane.showMessageDialog(frame,"Student isSelected!");

                            date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            MemberId = Integer.parseInt(txtMemberId.getText());
                            name = txtUserName.getText();
                            adress = txtUserAdress.getText();
                            phone = txtUserPhone.getText();

                            ml.addStudent(MemberId,"Student",name,adress,phone,date);
                            memberTable.updateUI();

                            Student.setSelected(false);
                            txtMemberId.setText("");
                            txtUserName.setText("");
                            txtUserAdress.setText("");
                            txtUserPhone.setText("");
                        }
                        if(Faculty.isSelected()){
                            JOptionPane.showMessageDialog(frame,"Faculty isSelected!");

                            date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                            MemberId = Integer.parseInt(txtMemberId.getText());
                            name = txtUserName.getText();
                            adress = txtUserAdress.getText();
                            phone = txtUserPhone.getText();


                            ml.addFaculty(MemberId,"Faculty",name,adress,phone,date);
                            facultyTable.updateUI();

                            Faculty.setSelected(false);
                            txtMemberId.setText("");
                            txtUserName.setText("");
                            txtUserAdress.setText("");
                            txtUserPhone.setText("");

                        }
                    }else{
                        JOptionPane.showMessageDialog(frame,"is selected not work!");
                    }
                }
            }
        });

        memberTable.setRowHeight(30);
        memberTable.getColumnModel().getColumn(2).setPreferredWidth(110);
        memberTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        memberTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        memberTable.getColumnModel().getColumn(5).setPreferredWidth(140);
        memberTable.setSize(100,200);
        memberTable.setEnabled(false);
        memberTable.setAutoscrolls(true);

        facultyTable.setRowHeight(30);
        facultyTable.getColumnModel().getColumn(2).setPreferredWidth(110);
        facultyTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        facultyTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        facultyTable.getColumnModel().getColumn(5).setPreferredWidth(140);
        facultyTable.setSize(100,200);
        facultyTable.setEnabled(false);
        facultyTable.setAutoscrolls(true);


        // JPanel User Transaction Add
        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(addUserTransLabel, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        addUser.add(lblMemberId, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(txtMemberId, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        addUser.add(Student, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(Faculty, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        addUser.add(lblUserName,addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(txtUserName, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        addUser.add(lblUserAdress, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(txtUserAdress, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        addUser.add(lblUserPhone, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(txtUserPhone, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        addUser.add(addMember, addUserGBC);

        addUser.add(memberTable.getTableHeader(), addUserGBC);
        addUser.add(memberTable, addUserGBC);

        addUser.add(facultyTable.getTableHeader(), addUserGBC);
        addUser.add(facultyTable, addUserGBC);

        /* Add User section end */

        /* Add book section begin */
        JPanel addBook = new JPanel(new GridBagLayout());

        tabbedPane.addTab("Add Book",addBook);
        GridBagConstraints addGBC = new GridBagConstraints();
        addGBC.insets = new Insets(2,2,2,2);

        // Book add label begin
        JLabel addBookLabel= new JLabel("Add Book");
        addBookLabel.setBounds(65,68,46,14);
        addBookLabel.setForeground(Color.GRAY);
        addBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));



        // Book Add components
        JLabel lblbookId = new JLabel("Book Id:");
        JTextField txtbook = new JTextField();
        txtbook.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        txtbook.setColumns(30);

        JLabel lblAuthor = new JLabel("Author:");
        JTextField txtAuthor = new JTextField();
        txtAuthor.setColumns(30);

        JLabel lblName = new JLabel("Name:");
        JTextField txtName = new JTextField();
        txtName.setColumns(30);

        JLabel lblprice = new JLabel("Price:");
        JTextField txtPrice = new JTextField();
        txtPrice.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
        txtPrice.setColumns(30);


        JButton btnBookAdd = new JButton("Add");
        btnBookAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(txtbook.getText().isEmpty() || txtAuthor.getText().isEmpty()
                        || txtName.getText().isEmpty() || txtPrice.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "No empty information!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(frame,   "Book Id:"+txtbook.getText()+
                            "\nAuthor:"+txtAuthor.getText()+
                            "\nName:"+txtName.getText()+
                            "\nPrice:"+txtPrice.getText()+
                            "\n\nSuccesfull!");
                    int Id = Integer.parseInt(txtbook.getText());
                    String aut = txtAuthor.getText();
                    String name = txtName.getText();
                    double price = Double.parseDouble(txtPrice.getText());
                    ml.addBook(Id,aut,name,price,true);
                    bookTable.updateUI();

                }

                txtAuthor.setText("");
                txtbook.setText("");
                txtPrice.setText("");
                txtName.setText("");
            }
        });


        bookTable.setRowHeight(30);
        bookTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        bookTable.getColumnModel().getColumn(1).setPreferredWidth(130);
        bookTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        bookTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        bookTable.getColumnModel().getColumn(4).setPreferredWidth(50);

        bookTable.setSize(100,200);
        bookTable.setEnabled(false);
        bookTable.setAutoscrolls(true);



        // JPanel AddBook Transactions
        addGBC.anchor = GridBagConstraints.CENTER;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(addBookLabel, addGBC);

        addGBC.anchor = GridBagConstraints.EAST;
        addGBC.gridwidth = GridBagConstraints.RELATIVE;
        addBook.add(lblbookId, addGBC);
        addGBC.anchor = GridBagConstraints.WEST;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(txtbook, addGBC);

        addGBC.anchor = GridBagConstraints.EAST;
        addGBC.gridwidth = GridBagConstraints.RELATIVE;
        addBook.add(lblAuthor, addGBC);
        addGBC.anchor = GridBagConstraints.WEST;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(txtAuthor, addGBC);

        addGBC.anchor = GridBagConstraints.EAST;
        addGBC.gridwidth = GridBagConstraints.RELATIVE;
        addBook.add(lblName, addGBC);
        addGBC.anchor = GridBagConstraints.WEST;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(txtName, addGBC);

        addGBC.anchor = GridBagConstraints.EAST;
        addGBC.gridwidth = GridBagConstraints.RELATIVE;
        addBook.add(lblprice, addGBC);
        addGBC.anchor = GridBagConstraints.WEST;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(txtPrice, addGBC);

        addGBC.anchor = GridBagConstraints.CENTER;
        addGBC.gridwidth = GridBagConstraints.REMAINDER;
        addBook.add(btnBookAdd, addGBC);

        addBook.add(bookTable.getTableHeader(), addGBC);
        addBook.add(bookTable,addGBC);

        /* Add book section end */

        /* Request View section begin */
        JPanel reqView = new JPanel(new GridBagLayout());
        tabbedPane.addTab("Request View",reqView);
        GridBagConstraints addReqViewGBC = new GridBagConstraints();
        addReqViewGBC.insets = new Insets(2,2,2,2);

        // Request View label
        JLabel reqViewLabel = new JLabel("Requests View");
        reqViewLabel.setBounds(65,68,46,14);
        reqViewLabel.setForeground(Color.GRAY);
        reqViewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblTransactionId = new JLabel("Transaction ID");
        JTextField txtTransactionId = new JTextField();
        txtTransactionId.setColumns(15);
        JButton btnGive = new JButton("Export Book");
        btnGive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(txtTransactionId.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "No empty information!","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if(ml.transactionCheck(Integer.parseInt(txtTransactionId.getText()),Date)){
                        JOptionPane.showMessageDialog(frame, "Success Export!");
                        txtTransactionId.setText("");
                        transactionTable.updateUI();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Request Not Found!");
                        txtTransactionId.setText("");
                    }
                }

            }
        });

        transactionTable.setRowHeight(30);
        transactionTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        transactionTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        transactionTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        transactionTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        transactionTable.getColumnModel().getColumn(4).setPreferredWidth(150);

        transactionTable.setSize(100,200);
        transactionTable.setEnabled(false);
        transactionTable.setAutoscrolls(true);


        addReqViewGBC.anchor = GridBagConstraints.CENTER;
        addReqViewGBC.gridwidth = GridBagConstraints.REMAINDER;
        reqView.add(reqViewLabel, addReqViewGBC);
        reqView.add(transactionTable.getTableHeader(), addReqViewGBC);
        reqView.add(transactionTable,addReqViewGBC);

        addReqViewGBC.anchor = GridBagConstraints.EAST;
        addReqViewGBC.gridwidth = GridBagConstraints.RELATIVE;
        reqView.add(lblTransactionId,addReqViewGBC);
        addReqViewGBC.anchor = GridBagConstraints.WEST;
        addReqViewGBC.gridwidth = GridBagConstraints.REMAINDER;
        reqView.add(txtTransactionId,addReqViewGBC);
        reqView.add(btnGive,addReqViewGBC);

        /* Request View section end */

        /* Return Book section begin */
        JPanel returnBook = new JPanel(new GridBagLayout());
        tabbedPane.addTab("Return Book",returnBook);

        GridBagConstraints addReturnBookGBC = new GridBagConstraints();
        addReturnBookGBC.insets = new Insets(2,2,2,2);

        // Return Book label
        JLabel returnBookLabel = new JLabel("Return Book");
        returnBookLabel.setBounds(65,68,46,14);
        returnBookLabel.setForeground(Color.GRAY);
        returnBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblReTransactionId = new JLabel("Transaction ID");
        JTextField txtReTransactionId = new JTextField();
        txtReTransactionId.setColumns(15);
        JButton btnReturn = new JButton("Return Book Accepted!");
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(txtReTransactionId.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame, "No empty information!","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if(ml.returnBookSet(Integer.parseInt(txtReTransactionId.getText()),Date)){
                        JOptionPane.showMessageDialog(frame, "Success Export!");
                        txtReTransactionId.setText("");
                        returnBookTable.updateUI();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Request Not Found!");
                        txtReTransactionId.setText("");
                    }
                }

            }
        });

        returnBookTable.setRowHeight(30);
        returnBookTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        returnBookTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        returnBookTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        returnBookTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        returnBookTable.getColumnModel().getColumn(4).setPreferredWidth(150);

        returnBookTable.setSize(100,200);
        returnBookTable.setEnabled(false);
        returnBookTable.setAutoscrolls(true);


        addReturnBookGBC.anchor = GridBagConstraints.CENTER;
        addReturnBookGBC.gridwidth = GridBagConstraints.REMAINDER;
        returnBook.add(returnBookLabel, addReturnBookGBC);
        returnBook.add(returnBookTable.getTableHeader(), addReturnBookGBC);
        returnBook.add(returnBookTable,addReturnBookGBC);

        addReturnBookGBC.anchor = GridBagConstraints.EAST;
        addReturnBookGBC.gridwidth = GridBagConstraints.RELATIVE;
        returnBook.add(lblReTransactionId,addReturnBookGBC);
        addReturnBookGBC.anchor = GridBagConstraints.WEST;
        addReturnBookGBC.gridwidth = GridBagConstraints.REMAINDER;
        returnBook.add(txtReTransactionId,addReturnBookGBC);
        returnBook.add(btnReturn,addReturnBookGBC);

        /* Return Book section end */

        /* Create Bill section begin */
        JPanel createBill = new JPanel(new GridBagLayout());
        GridBagConstraints billGBC = new GridBagConstraints();
        JLabel createBillLabel = new JLabel("Return Book (Stack)");
        tabbedPane.addTab("Create Bill",createBill);
        createBillLabel.setBounds(65,68,46,14);
        createBillLabel.setForeground(Color.GRAY);
        createBillLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblmember = new JLabel("Member Id: ");
        JTextField txtMemberID = new JTextField();
        txtMemberID.setColumns(15);
        txtMemberID.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });

        JLabel lblAmount = new JLabel("Amount: ");
        JTextField txtAmount = new JTextField();
        txtAmount.setColumns(15);
        txtAmount.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });

        Random randomID = new Random();
        int BillNo= randomID.nextInt(1000)+600;
        JButton btnBillCreate = new JButton("Create!");
        btnBillCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(txtMemberID.getText().isEmpty() || txtAmount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "No empty information!","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(ml.checkUser(Integer.parseInt(txtMemberID.getText()))){
                        ml.addBill(BillNo,Date,Integer.parseInt(txtMemberID.getText()),Integer.parseInt(txtAmount.getText()));
                        JOptionPane.showMessageDialog(frame,"Success Create Bill!");
                        txtMemberID.setText("");
                        txtAmount.setText("");
                        billTable.updateUI();
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Member Id not found!","Error",JOptionPane.ERROR_MESSAGE);
                        txtMemberID.setText("");
                        txtAmount.setText("");
                    }
                }

            }
        });

        JButton btnDeleteBill = new JButton("Delete Bill");
        btnDeleteBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ml.deleteBill();
                billTable.updateUI();
            }
        });




        billTable.setRowHeight(30);
        billTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        billTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        billTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        billTable.getColumnModel().getColumn(3).setPreferredWidth(150);

        billGBC.anchor = GridBagConstraints.CENTER;
        billGBC.gridwidth = GridBagConstraints.REMAINDER;
        createBill.add(createBillLabel, billGBC);

        billGBC.anchor = GridBagConstraints.EAST;
        billGBC.gridwidth = GridBagConstraints.RELATIVE;
        createBill.add(lblmember, billGBC);
        billGBC.anchor = GridBagConstraints.WEST;
        billGBC.gridwidth = GridBagConstraints.REMAINDER;
        createBill.add(txtMemberID,billGBC);

        billGBC.anchor = GridBagConstraints.EAST;
        billGBC.gridwidth = GridBagConstraints.RELATIVE;
        createBill.add(lblAmount, billGBC);
        billGBC.anchor = GridBagConstraints.WEST;
        billGBC.gridwidth = GridBagConstraints.REMAINDER;
        createBill.add(txtAmount,billGBC);

        billGBC.anchor = GridBagConstraints.CENTER;
        billGBC.gridwidth = GridBagConstraints.REMAINDER;
        createBill.add(btnBillCreate,billGBC);
        createBill.add(billTable.getTableHeader(), billGBC);
        createBill.add(billTable, billGBC);
        createBill.add(btnDeleteBill,billGBC);



        /* Create Bill section end */

        JPanel libReport = new JPanel(new GridBagLayout());
        GridBagConstraints libRGBC = new GridBagConstraints();
        tabbedPane.addTab("Library Report",libReport);
        JLabel lblTest = new JLabel("Coming Soon... Development!");
        libRGBC.anchor = GridBagConstraints.CENTER;
        libRGBC.gridwidth = GridBagConstraints.REMAINDER;
        libReport.add(lblTest,libRGBC);


        frame.add(btnBack, BorderLayout.SOUTH);
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
}