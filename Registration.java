package rsa2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Registration extends JFrame implements ActionListener {

    private String studentName;
    private String studentID;
    private static DefaultTableModel tableModel;
    private static JTable table;
    double totalPrice = 0.0;

    private JTextField nameField;
    private JTextField idField;
    private JRadioButton PharmacyButton;
    private JRadioButton EngineeringButton;
    private JRadioButton CSButton;
    private JRadioButton SIMButton;
    private JRadioButton DenButton;

    //constructor
    public Registration(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;

    }

    //setters
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    //getters
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    //Defaultconstructor
    public Registration() {
        // Create a new JFrame window
        JFrame frame = new JFrame("Register Course");

        // Set the size of the windowand center it on the screen
        frame.setSize(550, 375);
        frame.setLocationRelativeTo(null);

        // Create a new JPanel to hold the radio buttons, label and button
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout with vertical alignment

        // Create the name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 25));
        nameField = new JTextField(40);

        // Create the ID label and text field
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 25));
        idField = new JTextField(40);

        // Add the name label and text field to the panel
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(idLabel);
        panel.add(idField);

        // Create the "Confirm" button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font size to 24
        confirmButton.setBackground(new Color(206, 183, 111, 255));
        confirmButton.addActionListener(new ConfirmButtonListener());

        // Add the "Confirm" button to the panel
        panel.add(confirmButton);

        // Create a new JPanel with FlowLayout and add the panel to it
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(panel);

        // Add the centered panel to the window
        frame.add(centerPanel);

        // Set the window to exit when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the window visible

        frame.setVisible(true);

    }

    // Action listener for the "Confirm" button
    class ConfirmButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String studentName = nameField.getText();
            String studentID = idField.getText();
            JFrame frame = new JFrame("Courses");
            
            // Dispose of the old frame
            ((JFrame) SwingUtilities.getWindowAncestor((JButton) ae.getSource())).dispose();
            
            // First, define the courses for each faculty
            String[] pharmacyCourses = new String[]{"Pharmacology", "Pharmaceutics", "Pharmacognosy", "Pharmaceutical Chemistry", "Pharmacy Practice", "Pharmaceutical Microbiology", "English", "Phytochemistry"};
            String[] engineeringCourses = new String[]{"Civil Engineering", "Electrical Engineering", "Mechanical Engineering", "Chemical Engineering", "Computer Engineering", "Aerospace Engineering", "English", "Communication Skills"};
            String[] csCourses = new String[]{"Database", "Software Engineering Theory", "Computational Tools for Data Science", "Software Requirements Analysis", "AI for Game", "Design and Analysis of Algorithms"};
            String[] simCourses = new String[]{"Database", "Software Engineering Theory", "Computational Tools for Data Science", "Software Requirements Analysis", "AI for Game", "Design and Analysis of Algorithms"};
            String[] dentistryCourses = new String[]{"Dentistry", "Radiology", "Oral Pathology", "Periodontology", "Prosthodontics", "Endodontics", "English"};

            // Define the table for displaying the selected courses
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Course Name");
            model.addColumn("Hall");
            model.addColumn("Time");
            model.addColumn("Price");
            model.addColumn("Instructor");

            // Create a map to store the courses for each faculty
            Map<String, String[]> facultyCourses = new HashMap<>();
            facultyCourses.put("Pharmacy", pharmacyCourses);
            facultyCourses.put("Engineering", engineeringCourses);
            facultyCourses.put("Computer Science", csCourses);
            facultyCourses.put("Science", simCourses);
            facultyCourses.put("Dentistry", dentistryCourses);

            // Create a dialog for the user to select their faculty
            JComboBox<String> facultyBox = new JComboBox<>(new String[]{"Pharmacy", "Engineering", "Computer Science", "Science", "Dentistry"});
            JOptionPane.showMessageDialog(null, facultyBox, "Select Your Faculty", JOptionPane.PLAIN_MESSAGE);

            // Get the selected facultyContinued...
            String selectedFaculty = (String) facultyBox.getSelectedItem();

            // Create a dialog to display the courses for the selected faculty and let the user select the courses they want
            JCheckBox[] courseBoxes = new JCheckBox[facultyCourses.get(selectedFaculty).length];
            for (int i = 0; i < courseBoxes.length; i++) {
                courseBoxes[i] = new JCheckBox(facultyCourses.get(selectedFaculty)[i]);

            }
            JOptionPane.showMessageDialog(null, courseBoxes, "Select Your Courses", JOptionPane.PLAIN_MESSAGE);

            // Create a list to store the selected courses
            List<String> selectedCourses = new ArrayList<>();

            // Iterate through the selected courses and add them to the table and list
            for (int i = 0; i < courseBoxes.length; i++) {
                if (courseBoxes[i].isSelected()) {
                    // code to add selected course to table and list

// Add a new row to the table with the total price
                    String courseName = courseBoxes[i].getText();
                    String hallValue = "";
                    String timeValue = "";
                    String priceValue = "";
                    String instructorValue = "";
//------------------------------------------------------------------------------------
                    if (selectedFaculty.equals("Pharmacy")) {
                        if (courseName.equals("Pharmacology")) {
                            hallValue = "Room A1";
                            timeValue = "MWF 8:00-9:30 AM";
                            priceValue = "$500";
                            instructorValue = "Dr. Smith";
                        } else if (courseName.equals("Pharmaceutics")) {
                            hallValue = "Room A2";
                            timeValue = "TTh 11:00-12:30 PM";
                            priceValue = "$550";
                            instructorValue = "Dr. Johnson";
                        } else if (courseName.equals("Pharmacognosy")) {
                            hallValue = "Room A3";
                            timeValue = "MWF 10:00-11:30 AM";
                            priceValue = "$600";
                            instructorValue = "Dr. Williams";
                        } else if (courseName.equals("Pharmaceutical Chemistry")) {
                            hallValue = "Room A4";
                            timeValue = "TTh 9:00-10:30 AM";
                            priceValue = "$650";
                            instructorValue = "Dr. Brown";
                        } else if (courseName.equals("Pharmacy Practice")) {
                            hallValue = "Room A5";
                            timeValue = "MWF 2:00-3:30 PM";
                            priceValue = "$700";
                            instructorValue = "Dr. Davis";
                        } else if (courseName.equals("Pharmaceutical Microbiology")) {
                            hallValue = "Room A6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$750";
                            instructorValue = "Dr. Lee";
                        } else if (courseName.equals("English")) {
                            hallValue = "Room A7";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$620";
                            instructorValue = "Dr. Lee";
                        } else if (courseName.equals("Phytochemistry")) {
                            hallValue = "Room A8";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$750";
                            instructorValue = "Dr. Lee";
                        }
//-----------------------------------------------------------------------------------
                    } else if (selectedFaculty.equals("Engineering")) {
                        if (courseName.equals("Civil Engineering")) {
                            hallValue = "Room B1";
                            timeValue = "MWF 8:00-9:30 AM";
                            priceValue = "$600";
                            instructorValue = "Dr. Smith";
                        } else if (courseName.equals("Electrical Engineering")) {
                            hallValue = "Room B2";
                            timeValue = "TTh 11:00-12:30 PM";
                            priceValue = "$650";
                            instructorValue = "Dr. Johnson";
                        } else if (courseName.equals("Mechanical Engineering")) {
                            hallValue = "Room B3";
                            timeValue = "MWF 10:00-11:30 AM";
                            priceValue = "$700";
                            instructorValue = "Dr. Williams";
                        } else if (courseName.equals("Chemical Engineering")) {
                            hallValue = "Room B4";
                            timeValue = "TTh 9:00-10:30 AM";
                            priceValue = "$750";
                            instructorValue = "Dr. Brown";
                        } else if (courseName.equals("Computer Engineering")) {
                            hallValue = "Room B5";
                            timeValue = "MWF 2:00-3:30PM";
                            priceValue = "$800";
                            instructorValue = "Dr. Davis";
                        } else if (courseName.equals("Aerospace Engineering")) {
                            hallValue = "Room B6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$850";
                            instructorValue = "Dr. Lee";
                        } else if (courseName.equals("English")) {
                            hallValue = "Room A7";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$620";
                            instructorValue = "Dr. Lee";
                        } else if (courseName.equals("Communication Skills")) {
                            hallValue = "Room A7";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$620";
                            instructorValue = "Dr. Lee";
                        }
//-------------------------------------------------------------------------------------------
                    } else if (selectedFaculty.equals("Computer Science")) {
                        if (courseName.equals("Database")) {
                            hallValue = "Room D1";
                            timeValue = "MWF 8:00-9:30 AM";
                            priceValue = "$650";
                            instructorValue = "Dr. White";
                        } else if (courseName.equals("Software Engineering Theory")) {
                            hallValue = "Room D2";
                            timeValue = "TTh 11:00-12:30 PM";
                            priceValue = "$700";
                            instructorValue = "Dr. Green";
                        } else if (courseName.equals("Computational Tools for Data Science")) {
                            hallValue = "Room D3";
                            timeValue = "MWF 10:00-11:30 AM";
                            priceValue = "$750";
                            instructorValue = "Dr. Black";
                        } else if (courseName.equals("Software Requirements Analysis")) {
                            hallValue = "Room D4";
                            timeValue = "TTh 9:00-10:30 AM";
                            priceValue = "$800";
                            instructorValue = "Dr. Grey";
                        } else if (courseName.equals("AI for Game")) {
                            hallValue = "Room D5";
                            timeValue = "MWF 1:00-2:30 PM";
                            priceValue = "$850";
                            instructorValue = "Dr. Brown";
                        } else if (courseName.equals("Design and Analysis of Algorithms")) {
                            hallValue = "Room D6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$900";
                            instructorValue = "Dr. Yellow";
                        }
//--------------------------------------------------------------------------------------
                    } else if (selectedFaculty.equals("Science")) {
                        if (courseName.equals("Database")) {
                            hallValue = "Room D1";
                            timeValue = "MWF 8:00-9:30 AM";
                            priceValue = "$450";
                            instructorValue = "Dr. White";
                        } else if (courseName.equals("Software Engineering Theory")) {
                            hallValue = "Room D2";
                            timeValue = "TTh 11:00-12:30 PM";
                            priceValue = "$650";
                            instructorValue = "Dr. Green";
                        } else if (courseName.equals("Computational Tools for Data Science")) {
                            hallValue = "Room D3";
                            timeValue = "MWF 10:00-11:30 AM";
                            priceValue = "$700";
                            instructorValue = "Dr. Black";
                        } else if (courseName.equals("Software Requirements Analysis")) {
                            hallValue = "Room D4";
                            timeValue = "TTh 9:00-10:30 AM";
                            priceValue = "$750";
                            instructorValue = "Dr. Grey";
                        } else if (courseName.equals("AI for Game")) {
                            hallValue = "Room D5";
                            timeValue = "MWF 1:00-2:30 PM";
                            priceValue = "$900";
                            instructorValue = "Dr. Brown";
                        } else if (courseName.equals("Design and Analysis of Algorithms")) {
                            hallValue = "Room D6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$850";
                            instructorValue = "Dr. Yellow";
                        }
//--------------------------------------------------------------------------------------------
                    } else if (selectedFaculty.equals("Dentistry")) {
                        if (courseName.equals("Oral Biology")) {
                            hallValue = "Room E1";
                            timeValue = "MWF 8:00-9:30 AM";
                            priceValue = "$700";
                            instructorValue = "Dr. Smith";
                        } else if (courseName.equals("Radiology")) {
                            hallValue = "Room E2";
                            timeValue = "TTh 11:00-12:30 PM";
                            priceValue = "$750";
                            instructorValue = "Dr. Johnson";
                        } else if (courseName.equals("Oral Pathology")) {
                            hallValue = "Room E3";
                            timeValue = "MWF 10:00-11:30 AM";
                            priceValue = "$800";
                            instructorValue = "Dr. Williams";
                        } else if (courseName.equals("Periodontology")) {
                            hallValue = "Room E4";
                            timeValue = "TTh 9:00-10:30 AM";
                            priceValue = "$850";
                            instructorValue = "Dr. Brown";
                        } else if (courseName.equals("Prosthodontics")) {
                            hallValue = "Room E5";
                            timeValue = "MWF 2:00-3:30 PM";
                            priceValue = "$900";
                            instructorValue = "Dr. Davis";
                        } else if (courseName.equals("Endodontics")) {
                            hallValue = "Room E6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$950";
                            instructorValue = "Dr. Lee";
                        } else if (courseName.equals("English")) {
                            hallValue = "Room E6";
                            timeValue = "TTh 1:00-2:30 PM";
                            priceValue = "$950";
                            instructorValue = "Dr. Lee";
                        }

                    }
                    totalPrice += Double.parseDouble(priceValue.substring(1));

//----------------------------------------------------------------------------------------
                    // Add a new row to the table with the selected course and its corresponding values
                    model.addRow(new Object[]{courseName, hallValue, timeValue, priceValue, instructorValue});
                    model.addRow(new Object[]{"", "", "", "Total: $" + String.format("%.2f", totalPrice), ""});
// Add the course's price to the total price
                    // Add the selected course to the list of selected courses
                    selectedCourses.add(courseName);
                }
            }

            // Write student data to stdData.txt
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("stdData.txt"));
                writer.write("Name: " + studentName);
                writer.newLine();
                writer.write("ID: " + studentID);
                writer.newLine();
                writer.write("Selected Courses: ");
                for (String course : selectedCourses) {
                    writer.write(course + ", ");

                }
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create a dialog to display the selected courses in a table
            JTable table = new JTable(model);
            JOptionPane.showMessageDialog(null, new JScrollPane(table), "Selected Courses", JOptionPane.PLAIN_MESSAGE);
            // Add a "Total" row to the bottom of the table
            model.addRow(new Object[]{"", "", "", "Total: $" + String.format("%.2f", totalPrice), ""});
            JOptionPane.showMessageDialog(null, "You Have Registed Succssfully !");

            frame.dispose();

        }
    }
    // Action listener for the radio buttons

    public void actionPerformed(ActionEvent ae) {
        // ...
    }

    public void displaySelectedCourses(List<String> selectedCourses, String hallValue, String timeValue, String priceValue, String instructorValue) {
        JFrame frame = new JFrame("Registered Courses");
        frame.setSize(500, 300);
        String[] columnNames = {"Course Name", "Hall", "Time", "Price", "Instructor"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (String course : selectedCourses) {
            model.addRow(new Object[]{course, hallValue, timeValue, priceValue, instructorValue});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Registration().setVisible(true);

    }
}
