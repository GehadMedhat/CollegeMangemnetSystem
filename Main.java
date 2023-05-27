package rsa2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main implements ActionListener {

    static JButton instructorButton;
    static JButton studentButton;
    static JFrame home;
    static JFrame instructorWindow;
    static JFrame studentWindow;

    public static void main(String[] args) {
        home = new JFrame();
        home.getContentPane().setLayout(null);
        home.setSize(1050, 643);
        ImageIcon ii1 = new ImageIcon();
        JLabel l1 = new JLabel();
        l1.setSize(1050, 620);
        ii1 = new ImageIcon("src/rsa2/uni.png");
        Image img = ii1.getImage();
        Image imgg = img.getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scalemenu = new ImageIcon(imgg);
        l1.setIcon(scalemenu);
        JLabel homeLabel = new JLabel("LOGIN AS");
        homeLabel.setBounds(655, 150, 200, 30);
        homeLabel.setForeground(new Color(206, 183, 111, 255));
        homeLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        studentButton = new JButton("Student");
        studentButton.setBounds(620, 240, 200, 60);
        studentButton.setFont(new Font("", Font.BOLD, 24));
        studentButton.setBackground(new Color(206, 183, 111, 255));
        studentButton.addActionListener(new Main());
        instructorButton = new JButton("Instructor");
        instructorButton.setBounds(620, 320, 200, 60);
        instructorButton.setFont(new Font("", Font.BOLD, 24));
        instructorButton.setBackground(new Color(206, 183, 111, 255));
        instructorButton.addActionListener(new Main());
        home.add(homeLabel);
        home.add(studentButton);
        home.add(instructorButton);
        home.add(l1);
        home.setVisible(true);
        home.setLocation(250, 250);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null); // Center the window
        home.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JLabel l2 = new JLabel();
        l2.setBounds(20, 0, 60, 60);
        ImageIcon ii2 = new ImageIcon("src/rsa2/uni.png");
        Image img = ii2.getImage();
        Image logo = img.getScaledInstance(l2.getWidth(), l2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scalemenu = new ImageIcon(logo);
        l2.setIcon(scalemenu);

        if (e.getSource() == instructorButton) {
            home.setVisible(false); // hide the first page
            home.dispose();
            instructorWindow = new JFrame();
            instructorWindow.setSize(1000, 650);
            instructorWindow.setLocationRelativeTo(null);
            instructorWindow.setTitle("Instructor Portal");
            instructorWindow.getContentPane().setLayout(null);

            // to call Login class
            Login login = new Login();

        }
        if (e.getSource() == studentButton) {
            home.setVisible(false); // hide the first page
            home.dispose();
            // Create the new JFrame for the student portal
            studentWindow = new JFrame();
            studentWindow.setSize(1000, 650);
            studentWindow.setLocationRelativeTo(null);
            studentWindow.setTitle("Student Portal");
            studentWindow.getContentPane().setLayout(null);
            // to call Login class
            Login login = new Login();
        }
    }

}
