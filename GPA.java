package rsa2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GPA extends JFrame implements ActionListener {

    // Declare GUI components
    private JTextField courseNumField;
    private JButton nextButton;
    private JLabel resultLabel;
    private JTable courseTable;
    private JButton calculateButton;
    private ArrayList<String[]> courseData;

    // Constructor
    public GPA() {
        // Set window properties
        setTitle("GPA Calculator");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Initialize GUI components
        // Create the JLabel and JTextField components
        JLabel courseNumLbl = new JLabel("How many courses do you want to calculate GPA for?");
        courseNumField = new JTextField(2);

        // Add the components to the frame
        add(courseNumLbl);
        add(courseNumField);

        // Create the JButton component
        nextButton = new JButton("Next");

        // Set the ActionListener for the button
        nextButton.addActionListener(this);
        add(nextButton);

        // Create the result JLabel component and add it to the frame
        resultLabel = new JLabel("");
        add(resultLabel);

        // Create the JTable component and add it to the frame
        courseTable = new JTable();
        courseTable.setModel(new DefaultTableModel(new Object[]{"Course Name", "Credits", "Grade"}, 0));
        add(courseTable);

        // Create the JButton component
        calculateButton = new JButton("Calculate GPA");

        // Set the ActionListener for the button
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Initialize the courseData ArrayList
        courseData = new ArrayList<>();
    }

    // ActionListener method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Get the number of courses to calculate GPA for
            int numCourses = Integer.parseInt(courseNumField.getText());

            // Create the input dialog box for each course
            for (int i = 0; i < numCourses; i++) {
                JPanel coursePanel = new JPanel();
                JTextField courseNameField = new JTextField(10);
                JTextField creditsField = new JTextField(2);
                String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
                JComboBox<String> gradeCombo = new JComboBox<>(grades);

                coursePanel.add(new JLabel("Course Name:"));
                coursePanel.add(courseNameField);
                coursePanel.add(new JLabel("Credits:"));
                // Add the components to the coursePanel
                coursePanel.add(creditsField);
                coursePanel.add(new JLabel("Grade:"));
                coursePanel.add(gradeCombo);

                // Show the input dialog box and wait for user input
                int result = JOptionPane.showConfirmDialog(null, coursePanel, "Course " + (i + 1), JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    String[] courseInfo = new String[3];
                    courseInfo[0] = courseNameField.getText();
                    courseInfo[1] = creditsField.getText();
                    courseInfo[2] = (String) gradeCombo.getSelectedItem();
                    courseData.add(courseInfo);

                    // Add the course data to the JTable
                    DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
                    model.addRow(courseInfo);
                }
            }
        } else if (e.getSource() == calculateButton) {
            // Calculate the GPA
            double totalCredits = 0;
            double totalPoints = 0;
            for (String[] course : courseData) {
                double credits = Double.parseDouble(course[1]);
                totalCredits += credits;
                String grade = course[2];
                double points = 0;
                switch (grade) {
                    case "A":
                        points = 4.0;
                        break;
                    case "A-":
                        points = 3.7;
                        break;
                    case "B+":
                        points = 3.3;
                        break;
                    case "B":
                        points = 3.0;
                        break;
                    case "B-":
                        points = 2.7;
                        break;
                    case "C+":
                        points = 2.3;
                        break;
                    case "C":
                        points = 2.0;
                        break;
                    case "C-":
                        points = 1.7;
                        break;
                    case "D+":
                        points = 1.3;
                        break;
                    case "D":
                        points = 1.0;
                        break;
                    case "F":
                        points = 0.0;
                        break;
                }
                totalPoints += points * credits;
            }
            double gpa = totalPoints / totalCredits;

            // Display the GPA
            resultLabel.setText("Your GPA is: " + String.format("%.2f", gpa));

            // Save the course data to a file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"));
                for (String[] course : courseData) {
                    writer.write(course[0] + "," + course[1] + "," + course[2]);
                    writer.newLine();
                }
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GPA gpa = new GPA();
        gpa.setVisible(true);
    }
}
