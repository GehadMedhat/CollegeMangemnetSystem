package rsa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Instructor extends JFrame implements ActionListener {

    private JTextField fNameField, sNameField, addressField, emailField, dobField, phoneField, educationField, teachingField, expertiseField;
    private JButton submitButton, profile, cancelButton;

    public Instructor() {

        setTitle("New Instructor Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 4));

        JLabel fNameLabel = new JLabel("   First Name:");
        fNameLabel.setBounds(30, 50, 80, 20);
        add(fNameLabel);
        fNameField = new JTextField();
        fNameField.setBounds(120, 50, 120, 20);
        add(fNameField);

        JLabel sNameLabel = new JLabel("   Second Name:");
        sNameLabel.setBounds(30, 80, 100, 20);
        add(sNameLabel);
        sNameField = new JTextField();
        sNameField.setBounds(120, 80, 120, 20);
        add(sNameField);

        JLabel addressLabel = new JLabel("  Address:");
        addressLabel.setBounds(30, 110, 80, 20);
        add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(120, 110, 150, 20);
        add(addressField);

        JLabel emailLabel = new JLabel("   Email:");
        emailLabel.setBounds(30, 140, 80, 20);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(120, 140, 150, 20);
        add(emailField);

        JLabel dobLabel = new JLabel("   Date of Birth:");
        dobLabel.setBounds(30, 170, 100, 20);
        add(dobLabel);
        dobField = new JTextField();
        dobField.setBounds(120, 170, 150, 20);
        add(dobField);

        JLabel phoneLabel = new JLabel("   Phone:");
        phoneLabel.setBounds(30, 200, 80, 20);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(120, 200, 150, 20);
        add(phoneField);

        JLabel educationLabel = new JLabel("   Educational Qualifications:");
        educationLabel.setBounds(30, 230, 170, 20);
        add(educationLabel);
        educationField = new JTextField();
        educationField.setBounds(200, 230, 150, 20);
        add(educationField);

        JLabel teachingLabel = new JLabel("   Teaching Experience:");
        teachingLabel.setBounds(30, 260, 170, 20);
        add(teachingLabel);
        teachingField = new JTextField();
        teachingField.setBounds(200, 260, 150, 20);
        add(teachingField);

        JLabel expertiseLabel = new JLabel("   Scholarly Expertise:");
        expertiseLabel.setBounds(30, 290, 170, 20);
        add(expertiseLabel);
        expertiseField = new JTextField();
        expertiseField.setBounds(200, 290, 150, 20);
        add(expertiseField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 330, 100, 30);
        submitButton.setBackground(new Color(206, 183, 111, 225));
        submitButtonContinuation:

        submitButton.addActionListener(this);
        add(submitButton);

        profile = new JButton("See my Data");
        profile.setBounds(160, 330, 120, 30);
        profile.setBackground(new Color(206, 183, 111, 225));
        profile.addActionListener(this);
        add(profile);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(290, 330, 100, 30);
        cancelButton.setBackground(new Color(206, 183, 111, 225));
        cancelButton.addActionListener(this);
        add(cancelButton);

        pack();
        setSize(400, 400);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String fName = fNameField.getText();
            String sName = sNameField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String dob = dobField.getText();
            String phone = phoneField.getText();
            String education = educationField.getText();
            String teaching = teachingField.getText();
            String expertise = expertiseField.getText();

            if (fName.isEmpty() || sName.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter values for all required fields.");
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("instData.txt", true))) {
                    writer.write("First Name, Second Name, Address, Email, Dateof Birth, Phone, Educational Qualifications, Teaching Experience, Scholarly Expertise\n");
                    writer.write(fName + ", ");
                    writer.write(sName + ", ");
                    writer.write(address + ", ");
                    writer.write(email + ", ");
                    writer.write(dob + ", ");
                    writer.write(phone + ",");
                    writer.write(education + ",");
                    writer.write(teaching + ",");
                    writer.write(expertise);
                    writer.newLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(this, "Your details saved successfully!");

            }
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
                {"Date of Birth", dobField.getText()},
                {"Phone", phoneField.getText()},
                {"Educational Qualifications", educationField.getText()},
                {"Teaching Experience", teachingField.getText()},
                {"Scholarly Expertise", expertiseField.getText()}};

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
        Instructor instructor = new Instructor();
    }
}
