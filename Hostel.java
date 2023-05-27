package rsa2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hostel extends JFrame implements ActionListener {

    JLabel l;
    JButton confirmButton;
    JPanel contentpane;

    public Hostel() {

        // Create a new JFrame window
        JFrame frame = new JFrame("Gender Selection");

        // Set the size of the window
        frame.setSize(550, 375);

        // Set the window to not be resizable
        frame.setResizable(false);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Create a newJPanel to hold the radio buttons, label and button
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout with vertical alignment

        // Create the label for the gender selection
        JLabel genderLabel = new JLabel("   Gender: ");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font size to 24
        genderLabel.setForeground(Color.RED);

        // Create the radio buttons and add them to a ButtonGroup
        JRadioButton boyButton = new JRadioButton("Boy");
        JRadioButton girlButton = new JRadioButton("Girl");
        boyButton.setFont(new Font("Arial", Font.BOLD, 60)); // Set the font size to 60
        girlButton.setFont(new Font("Arial", Font.BOLD, 60)); // Set the font size to 60
        ButtonGroup group = new ButtonGroup();
        group.add(boyButton);
        group.add(girlButton);

        //Create the "Confirm" button
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new window or page here
            }
        });
        confirmButton.setFont(new Font("Arial", Font.BOLD, 24)); // Set the font size to 24
        confirmButton.setBackground(new Color(206, 183, 111, 255));

        // Add the label, radio buttonsand button to the panel
        panel.add(Box.createVerticalGlue()); // Add vertical glue to center the label
        panel.add(genderLabel);
        panel.add(Box.createVerticalStrut(30)); // Add vertical strut to create a new line
        panel.add(boyButton);
        panel.add(Box.createVerticalStrut(30)); // Add vertical strut to create a new line
        panel.add(girlButton);
        panel.add(Box.createVerticalStrut(30)); // Add vertical strut to create a new line
        panel.add(confirmButton);

        // Add the action listener for the confirm button
        confirmButton.addActionListener(this);

        // Create a new JPanel with FlowLayout to center the panel
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(panel);

        // Add the centered panel to the window
        frame.add(centerPanel);

        // Set the window to exit when closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        frame.setVisible(true);
    }
//-----------------------------------------------------------------

    public class MyPage extends JFrame {

        private String name; // variable to store the user's name

        public MyPage() {

            // Set the size of the window
            setSize(474, 316);

            // Set the window to exit when closed
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create the name label and text field
            JLabel nameLabel = new JLabel("Name:");
            nameLabel.setFont(new Font("Arial", Font.BOLD, 25));
            JTextField nameField = new JTextField(40);

            // Create the ID label and text field
            JLabel idLabel = new JLabel("ID:");
            idLabel.setFont(new Font("Arial", Font.BOLD, 25));
            JTextField idField = new JTextField(40);

            // Create the exit button
            JButton exitButton = new JButton("Exit");
            exitButton.setBackground(new Color(206, 183, 111, 255));
            exitButton.setFont(new Font("Helvetica", Font.BOLD, 17));

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Exit the application
                    System.exit(0);
                }
            });

            // Create the next button
            JButton nextButton = new JButton("Next");
            nextButton.setBackground(new Color(206, 183, 111, 255));
            nextButton.setFont(new Font("Helvetica", Font.BOLD, 17));
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Save the name entered by the user
                    name = nameField.getText();

                    // Create a new JFrame for the next page
                    JFrame nextFrame = new JFrame("Hostel ");

                    // Set the size of the window
                    nextFrame.setSize(800, 600);

                    // Set the window to exit when closed
                    nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Create a label to display the user's name
                    JLabel nameLabel = new JLabel("Hello, " + name + "!");
                    nameLabel.setForeground(Color.RED);
                    nameLabel.setFont(new Font("tahoma", Font.BOLD, 20));

                    // Add the name label to the new frame
                    nextFrame.add(nameLabel, BorderLayout.NORTH);

                    // Create the data for the table
                    Object[][] data = {
                        {"101", "1500$", "Available"},
                        {"102", "1500$", "Available"},
                        {"103", "3000$", "Available"},
                        {"104", "1500$", "Available"},
                        {"105", "2100$", "Available"},
                        {"106", "2100$", "Available"},
                        {"107", "1500$", "Available"},
                        {"108", "2100$", "Available"},
                        {"109", "1500$", "Available"},
                        {"110", "3000$", "Available"},
                        {"111", "3000$", "Available"},
                        {"112", "3000$", "Available"}
                    };

                    // Create the column names for the table
                    Object[] columnNames = {"Room Number", "Monthly Price", "Availability"};

                    // Create the JTable with the data and column names
                    JTable table = new JTable(data, columnNames);

                    // Add the table to a JScrollPane
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Set the preferred size of the JScrollPane
                    scrollPane.setPreferredSize(new Dimension(750, 500));

                    // Create a label for the "Number of room" text
                    JLabel numberOfRoomsLabel = new JLabel("Room Number:");

                    // Create a text field for the user to enter the number of rooms
                    JTextField numberOfRoomsField = new JTextField(10);

                    // Create a button for the user to click to book the rooms
                    JButton bookButton = new JButton("Book");

                    bookButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Get the room number entered by the user
                            String roomNumberStr = numberOfRoomsField.getText();

                            // Loop through the rows of the table to find the selected room
                            for (int i = 0; i < data.length; i++) {
                                if (data[i][0].equals(roomNumberStr)) {
                                    // Update the availability status of the selected room in the table
                                    data[i][2] = "Not Available";
                                    break;
                                }
                            }

                            // Update the table model to reflect the changes
                            table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                            try {
                                int roomNumber = Integer.parseInt(roomNumberStr);

                                if (roomNumber >= 101 && roomNumber <= 112) {
                                    JOptionPane.showMessageDialog(null, "Room " + roomNumber + " has been booked successfully!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Room " + roomNumber + " doesn't exist!");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                            // Display a message showing the room has been booked successfully with the room number
                           

                            // TODO: Handle booking logic here
                        }
                    });

                    // Create a new panel for the "Number of room" components
                    JPanel bookingPanel = new JPanel();

                    // Add the "Number of room" label to the panel
                    bookingPanel.add(numberOfRoomsLabel);

                    // Add the text field to the panel
                    bookingPanel.add(numberOfRoomsField);

                    // Add the book button to the panel
                    bookingPanel.add(bookButton);

                    // Create a new panel to hold all the components
                    JPanel mainPanel = new JPanel(new BorderLayout());

                    // Add the JScrollPane to the center of the main panel
                    mainPanel.add(scrollPane, BorderLayout.CENTER);

                    // Add the booking panel to the south of the main panel
                    mainPanel.add(bookingPanel, BorderLayout.SOUTH);

                    nextFrame.add(mainPanel);

                    // Dispose the current frame after creating the new frame
                    dispose();

                    // Set the nextFrame to be visible
                    nextFrame.setVisible(true);

                }
            });

            // Create a new JPanel for the components
            JPanel panel = new JPanel();

            // Add the ID label and text field to the panel
            panel.add(nameLabel);

            panel.add(nameField);

            panel.add(idLabel);

            panel.add(idField);

            // Add some spacing between the components
            panel.add(Box.createHorizontalStrut(10));

            // Add the exit button to the panel
            panel.add(exitButton);

            // Add some spacing between the components
            panel.add(Box.createHorizontalStrut(10));

            // Add the next button to the panel
            panel.add(nextButton);

            // Add the panel to the frame
            add(panel);

            // Set the frame to be visible
            setVisible(true);
        }

        // Getter method to retrieve the saved name
        public String getName() {
            return name;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirmButton) {
            // Hide the current window
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(confirmButton);
            frame.setVisible(false);
            new MyPage();
        }
    }
//-------------------------------------------------------------------------------

    public static void main(String[] args) {
        new Hostel().setVisible(true);
    }
}
