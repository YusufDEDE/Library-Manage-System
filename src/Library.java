//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import LibrarySystem.Main;



public class Library extends JFrame {

    Main ml = Main.getInstance();

    static Library frame;
    private JPanel contentPane;
    private static boolean alreadyExecutedStudent = false;
    private static boolean isAlreadyExecutedBook = false;
    private static boolean isAlreadyExecutedTransaction = false;
    private static boolean isAlreadyExecutedBill = false;
    private static String Date =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());


    public void addDefaultUser(){
        if(!alreadyExecutedStudent){

            ml.addStudent(250,"Student","John Watson","London","25845687",Date);
            ml.addStudent(251,"Student","Micheal Jackson","Toronto","25845687",Date);
            ml.addFaculty(252,"Faculty","Steve Ballmer","California","25845687",Date);
            System.out.println(ml.logStudent());
            alreadyExecutedStudent = true;
        }
    }

    public void addDefaulBook(){
        if(!isAlreadyExecutedBook){
            ml.addBook(101,"Victor Hugo","Les Miserables",12.99,true);
            ml.addBook(102,"Fyodor Dostoevsky","Crime and Punishment ",9.89,true);
            ml.addBook(103,"Edward Ardizzone","Robinson Crusoe",361,true);
            System.out.println(ml.logBook());
            isAlreadyExecutedBook = true;
        }
    }

    public void addDefaultTransaction(){
        if(!isAlreadyExecutedTransaction){
            ml.addTransaction(369,250,101,"","");
            System.out.println(ml.logTransaction());
        }
        isAlreadyExecutedTransaction = true;
    }

    public void addDefaultBill(){
        if(!isAlreadyExecutedBill){
            ml.addBill(1025,Date,252,20);
            System.out.println(ml.listBill());
        }
        isAlreadyExecutedBill = true;
    }

    public static void main(String[] args) {




        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Library.frame = new Library();
                    Library.frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public Library() {

        addDefaultUser();
        addDefaulBook();
        addDefaultTransaction();
        addDefaultBill();
        this.setDefaultCloseOperation(3);
        this.setBounds(500, 250, 450, 300);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        JLabel lblLibraryManagement = new JLabel("Library Management System");
        lblLibraryManagement.setFont(new Font("Tahoma", 0, 18));
        lblLibraryManagement.setForeground(Color.GRAY);
        JButton btnAdminLogin = new JButton("Librarian Login");
        btnAdminLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianLogin.main(new String[0]);
                Library.frame.setVisible(false);
            }
        });
        btnAdminLogin.setFont(new Font("Tahoma", 0, 15));
        JButton btnLibrarianLogin = new JButton("User | Guest");
        btnLibrarianLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                UserLogin.main(new String[0]);
                Library.frame.setVisible(false);
            }
        });
        btnLibrarianLogin.setFont(new Font("Tahoma", 0, 15));
        GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGap(64).addComponent(lblLibraryManagement)).addGroup(gl_contentPane.createSequentialGroup().addGap(140).addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false).addComponent(btnLibrarianLogin, Alignment.LEADING, -1, -1, 32767).addComponent(btnAdminLogin, Alignment.LEADING, -1, 135, 32767)))).addContainerGap(95, 32767)));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblLibraryManagement).addGap(32).addComponent(btnAdminLogin, -2, 52, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLibrarianLogin, -2, 53, -2).addContainerGap(70, 32767)));
        this.contentPane.setLayout(gl_contentPane);
    }
}
