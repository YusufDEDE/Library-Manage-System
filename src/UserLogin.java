import LibrarySystem.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    public static void main(String[] args) {

        Main ml = Main.getInstance();



        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 250, 450, 300);



        /* Add User section begin */
        JPanel UserLoginPanel = new JPanel(new GridBagLayout());


        GridBagConstraints addUserGBC = new GridBagConstraints();
        addUserGBC.insets = new Insets(2,2,2,2);

        JLabel addUserTransLabel = new JLabel("User Login");
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


        txtMemberId.setColumns(20);



        JButton btnCheckUser = new JButton("Login");

        btnCheckUser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(txtMemberId.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"No is member Empty!");
                }
                else{
                    if(ml.checkUser(Integer.parseInt(txtMemberId.getText()))){
                        ml.loginSetMemberId(Integer.parseInt(txtMemberId.getText()));
                        UserView.main(new String[0]);
                        frame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(frame,"Member ID not found!");
                    }
                }

            }
        });

        JButton btnBackLibray = new JButton("Back");
        btnBackLibray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Library.main(new String[0]);
                frame.dispose();
            }
        });



        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        UserLoginPanel.add(btnBackLibray, addUserGBC);


        addUserGBC.anchor = GridBagConstraints.CENTER;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        UserLoginPanel.add(addUserTransLabel, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        UserLoginPanel.add(lblMemberId, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        UserLoginPanel.add(txtMemberId, addUserGBC);

        addUserGBC.anchor = GridBagConstraints.EAST;
        addUserGBC.gridwidth = GridBagConstraints.RELATIVE;
        UserLoginPanel.add(btnBackLibray, addUserGBC);
        addUserGBC.anchor = GridBagConstraints.WEST;
        addUserGBC.gridwidth = GridBagConstraints.REMAINDER;
        UserLoginPanel.add(btnCheckUser, addUserGBC);

        frame.add(UserLoginPanel);
        frame.setSize(450, 300);
        frame.setVisible(true);
    }



}