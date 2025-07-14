package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    login() {

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(750, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 750, 300);
        label.setLayout(null);
        add(label);

        JLabel username = new JLabel("username");
        username.setBounds(40, 20, 100, 30);
        username.setFont(new Font("Tahoma", Font.BOLD, 20));
        username.setForeground(Color.BLACK);
        label.add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 20));
        password.setForeground(Color.BLACK);
        label.add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(250, 182, 22));
        label.add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(250, 182, 22));
        label.add(jPasswordField);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        label.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        label.add(b2);

        setSize(750, 300);
        setLocation(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                data c = new data();
                String username = textField.getText();
                String password = jPasswordField.getText();
                String q = "select * from login where ID = '" + username + "' and password = '" + password + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "login succesfully");
                    new Reception();
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "invalid");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(10);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}