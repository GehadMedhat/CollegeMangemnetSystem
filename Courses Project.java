package rsa2;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class Courses extends JFrame {

    private JPanel panel;
    private JLabel label;
    private JCheckBox[] Registed;
    private JButton button;
    private Registration registration;

    public Courses(String[] courses) {
        panel = new JPanel();
        label = new JLabel("Select the Courses you want to regist:");

        String[] Courses = courses;
        Registed = new JCheckBox[Courses.length];

        button = new JButton("Submit");

        for (int i = 0; i < Courses.length; i++) {
            Registed[i] = new JCheckBox(Courses[i]);
            panel.add(Registed[i]);
        }

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                java.util.List<String> selectedCoursesList = new java.util.ArrayList<>();

                for (JCheckBox Courses : Registed) {
                    if (Courses.isSelected()) {
                        selectedCoursesList.add(Courses.getText());
                    }
                }
                String[] selectedCourses = selectedCoursesList.toArray(new String[selectedCoursesList.size()]);
                // Here you can do whatever you want with the selected courses

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("stdData.txt", true));
//                    writer.write(""Name" + " ; " + "ID" + " ; " + "Registed Courses" + "\n");
                    for (String Course : selectedCourses) {
                        writer.write(" ; " + Course);
                    }
                    writer.write("\n");
                    writer.close();

                    JFrame tableFrame = new JFrame("Registered Courses");
                    tableFrame.setSize(500, 300);

                    String[] columnNames = {"Course Name"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    JTable table = new JTable(model);

                    for (String course : selectedCourses) {
                        model.addRow(new Object[]{course});
                    }

                    JScrollPane scrollPane = new JScrollPane(table);
                    tableFrame.add(scrollPane);
                    tableFrame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        panel.add(button);
        add(panel);

        setTitle("Regist Courses");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        String[] courses = {"Course 1", "Course 2", "Course 3"};
        Registration registration = new Registration();
        Courses coursesWindow = new Courses(courses);
    }

}
