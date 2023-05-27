package rsa2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutUs extends JFrame implements ActionListener {

    JLabel l;
    JButton b;
    JPanel contentpane;

    public AboutUs() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 475);
        setLocation(300, 300);
        setLayout(new BorderLayout());
        contentpane = new JPanel();
        contentpane.setBackground(Color.white);

        l = new JLabel("                 UNIVERSITY MANAGEMENT SYSTEM 2023");
        l.setForeground(new Color(0, 0, 0));
        l.setFont(new Font("tahoma", Font.BOLD, 20));
        add(l, "North");

        l = new JLabel("We are happy that you've chosen ALexandria National University !");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        l = new JLabel("Please visit us soon!");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        l = new JLabel("                                       Contact Us                                     ");
        l.setFont(new Font("Verdana", Font.BOLD, 17));
        l.setForeground(Color.RED);
        contentpane.add(l);

        l = new JLabel("                               Website: http://anu.alexu.edu.eg/registration/ArabDiploma.php                            ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        l.setForeground(Color.BLUE);
        contentpane.add(l);

        l = new JLabel("                                     E-mail: admission.anu@alexu.edu.eg                            ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        l.setForeground(Color.BLUE);
        contentpane.add(l);

        l = new JLabel("                                     FaceBook Page: AlexandriaNationalUniversity                            ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        l.setForeground(Color.BLUE);
        contentpane.add(l);

        l = new JLabel("                                     PhoneNumber: +20 128 071 6768                            ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        l.setForeground(Color.BLUE);
        contentpane.add(l);

        l = new JLabel("Alexandria National University aspires to restore the historic status of Alexandria University ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        l = new JLabel("and to achieve a comprehensive qualitative leap in various fields of knowledge within ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        l = new JLabel(" a frame work of noble human values, enabling it to take a leading position in its  ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        l = new JLabel("                      national , Arab, African, Mediterranean and global environments.               ");
        l.setFont(new Font("Aerial", Font.PLAIN, 15));
        contentpane.add(l);

        b = new JButton("Exit");
        b.setForeground(new Color(00, 0, 0));
        b.setBackground(new Color(206, 183, 111, 255));
        b.setFont(new Font("Helvetica", Font.BOLD, 17));
        contentpane.add(b);

        JScrollPane js = new JScrollPane(contentpane);

        add(contentpane, "Center");
        add(js, "East");

        b.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Have a Nice Day!");
        }
    }

    public static void main(String[] args) {
        new AboutUs().setVisible(true);
    }
}
