package rsa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Student extends JFrame implements ActionListener {

    private JTextField fNameField, sNameField, addressField, emailField, dobField, phoneField;
    private JComboBox<String> depBox;
    private JButton submitButton, cancelButton, gpaCalculator, registCourse, profile;

    public Student() {
        setTitle("New Student Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 4));

        JLabel fNameLabel = new JLabel("   First Name:");
        fNameLabel.setBounds(30, 50, 80, 20);
        add(fNameLabel);

        fNameField = new JTextField();
        fNameField.setBounds(120, 50, 120, 20);
        add(fNameField);

        JLabel sNameLabel = new JLabel("   Second Name:");
        sNameLabel.setBounds(30, 170, 100, 20);
        add(sNameLabel);

        sNameField = new JTextField();
        sNameField.setBounds(120, 170, 120, 20);
        add(sNameField);

        JLabel addressLabel = new JLabel("  Address:");
        addressLabel.setBounds(30, 80, 80, 20);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(120, 80, 150, 20);
        add(addressField);

        JLabel emailLabel = new JLabel("   Email:");
        emailLabel.setBounds(30, 110, 80, 20);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120, 110, 150, 20);
        add(emailField);

        JLabel depLabel = new JLabel("   Department:");
        depLabel.setBounds(30, 140, 80, 20);
        add(depLabel);

        String[] depOptions = {"Faculty of Science(SIM)", "Faculty of Computer science", "Faculty of Engineering", "Faculty of Pharmacy", "Faculty of Dentistry"};
        depBox = new JComboBox<>(depOptions);
        depBox.setBounds(120, 140, 150, 20);
        add(depBox);

        JLabel dobLabel = new JLabel("   Date of Birth:");
        dobLabel.setBounds(30, 200, 100, 20);
        add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(120, 200, 80, 20);
        add(dobField);

        JLabel phoneLabel = new JLabel("   Phone Number:");
        phoneLabel.setBounds(30, 230, 100, 20);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(120, 230, 120, 20);
        add(phoneField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 300, 100, 30);
        submitButton.setBackground(new Color(206, 183, 111, 225));
        submitButton.addActionListener(this);
        add(submitButton);

        gpaCalculator = new JButton("Calculate GPA");
        gpaCalculator.setBounds(50, 300, 100, 30);
        gpaCalculator.setBackground(new Color(206, 183, 111, 225));
        gpaCalculator.addActionListener(this);
        add(gpaCalculator);

        registCourse = new JButton("Regist Courses");
        registCourse.setBounds(50, 300, 100, 30);
        registCourse.setBackground(new Color(206, 183, 111, 225));
        registCourse.addActionListener(this);
        add(registCourse);

        profile = new JButton("See my Data");
        profile.setBounds(50, 300, 100, 30);
        profile.setBackground(new Color(206, 183, 111, 225));
        profile.addActionListener(this);
        add(profile);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 300, 100, 30);
        cancelButton.setBackground(new Color(206, 183, 111, 225));
        cancelButton.addActionListener(this);
        add(cancelButton);

        pack();
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String fName = fNameField.getText();
            String sName = sNameField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String department = depBox.getSelectedItem().toString();
            String dob = dobField.getText();
            String phone = phoneField.getText();

            if (fName.isEmpty() || sName.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter values for all required fields.");
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("stdData.txt", true))) {
                    writer.write("fName, sName, address, email, department, dateOfBirth, phone\n");
                    writer.write(fName + ", ");
                    writer.write(sName + ", ");
                    writer.write(address + ", ");
                    writer.write(email + ", ");
                    writer.write(department + ", ");
                    writer.write(dob + ",");
                    writer.write(phone);
                    writer.newLine();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "Student details saved successfully!");

            }
        } else if (e.getSource() == gpaCalculator) {
            // TODO: Implement GPA calculator
            GPA gpapage = new GPA();
            gpapage.setVisible(true);
        } else if (e.getSource() == registCourse) {
            // TODO: Implement course registration
            Registration regPage = new Registration();
        } else if (e.getSource() == profile) {
            // Create a dialog to show the user's data
            JDialog dialog = new JDialog(this, "Your Data");

            // Define the table data
            String[] columnNames = {"Field", "Value"};
            Object[][] data = {
                {"First Name", fNameField.getText()},
                {"Second Name", sNameField.getText()},
                {"Address", addressField.getText()},
                {"Email", emailField.getText()},
                {"Department", depBox.getSelectedItem().toString()},
                {"Date of Birth", dobField.getText()},
                {"Phone", phoneField.getText()}
            };

            // Create the table
            JTable table = new JTable(data, columnNames);

            // Add the table to a scroll pane
            JScrollPane scrollPane = new JScrollPane(table);
            dialog.getContentPane().add(scrollPane);

            // Set the size and visibility of the dialog
            dialog.pack();
            dialog.setSize(400, 300);
            dialog.setVisible(true);
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new Student();
    }
}
