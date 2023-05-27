package rsa2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bus extends JFrame {

    private JComboBox<String> f;
    private JButton jButton1;
    private JLabel jLabel1;

    private boolean[] seats = new boolean[21]; //Create an array to store the seat availability

    public void bookSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= 21) { // Check if the seat number is valid
            if (seats[seatNumber - 1]) { // Check if the seat has already been booked
                JOptionPane.showMessageDialog(null, "Seat " + seatNumber + " has already been booked!");
            } else {
                seats[seatNumber - 1] = true; // Book the seat
                JOptionPane.showMessageDialog(null, "Seat " + seatNumber + " has been booked successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seat " + seatNumber + " doesn't even exist!");
        }
    }

    public Bus() {

        JFrame frame = new JFrame("Bus");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(
                400, 300);
        frame.setLocationRelativeTo(
                null); // Center the window

        JPanel panel = new JPanel(new GridBagLayout()); // Use GridBagLayout to center the JComboBox

        f = new JComboBox<>();

        f.setFont(
                new java.awt.Font("Times New Roman", 0, 18));
        f.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"El Montazah 1 District",
            "El Montazah 2 District", "El Gomrok District", "Sharq District", "Wasat District", "Gharb District", "El Amriya 1 District", "El Amriya 2 District", "El Al-Ajmi District"}));

        jButton1 = new JButton("Submit");

        jButton1.setFont(
                new java.awt.Font("Times New Roman", 0, 18));
        jButton1.setBackground(
                new Color(206, 183, 111, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String selectedDistrict = (String) f.getSelectedItem();
                if (selectedDistrict.equals("El Montazah 1 District")) {
                    JFrame detailsFrame = new JFrame("Details for El Montazah 1 District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Montazah 1 District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El Montazah 1 District<br>"
                            + "Bus Number : 1<br>"
                            + "Pick-Up Time : 8.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : One Hour<br>"
                            + "Driver Name : Mohamed Ali<br>"
                            + "Price : 50$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //--------------------------------------------------------------------------------------
                if (selectedDistrict.equals("El Montazah 2 District")) {
                    JFrame detailsFrame = new JFrame("Details for El Montazah 2 District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Montazah 2 District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El Montazah 2 District<br>"
                            + "Bus Number : 2<br>"
                            + "Pick-Up Time : 7.30 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : One Hour and a Half<br>"
                            + "Driver Name : Ahmed Elsayed<br>"
                            + "Price : 75$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }//--------------------------------------------------------------------------------------
                if (selectedDistrict.equals("El Gomrok District")) {
                    JFrame detailsFrame = new JFrame("Details for El Gomrok District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Gomrok District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El El Gomrok District<br>"
                            + "Bus Number : 3<br>"
                            + "Pick-Up Time : 8.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : One Hour<br>"
                            + "Driver Name : Ibrahim Abbas<br>"
                            + "Price : 50$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }//----------------------------------------------------------------------------------
                if (selectedDistrict.equals("Sharq District")) {
                    JFrame detailsFrame = new JFrame("Details for Sharq District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for Sharq District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : Sharq District<br>"
                            + "Bus Number : 4<br>"
                            + "Pick-Up Time : 7.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : Two Hour<br>"
                            + "Driver Name : Abdelrahman Mousa<br>"
                            + "Price : 35$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //----------------------------------------------------------------------------------------
                if (selectedDistrict.equals("Wasat District")) {
                    JFrame detailsFrame = new JFrame("Details for Wasat Districtt");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for Wasat District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : Wasat District<br>"
                            + "Bus Number : 5<br>"
                            + "Pick-Up Time : 7.30 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : One Hour and a Half<br>"
                            + "Driver Name : Mahmoud Mustafa<br>"
                            + "Price : 50$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //-----------------------------------------------------------------------------------------
                if (selectedDistrict.equals("Gharb District")) {
                    JFrame detailsFrame = new JFrame("Details for Gharb District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for Gharb District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : Gharb District<br>"
                            + "Bus Number : 6<br>"
                            + "Pick-Up Time : 8.30 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : Half an Hour<br>"
                            + "Driver Name : Eslam Fathi<br>"
                            + "Price : 25$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //-----------------------------------------------------------------------------------------
                if (selectedDistrict.equals("El Amriya 1 District")) {
                    JFrame detailsFrame = new JFrame("Details for El Amriya 1 District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Amriya 1 District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El Amriya 1 District<br>"
                            + "Bus Number : 7<br>"
                            + "Pick-Up Time : 7.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : Two Hours<br>"
                            + "Driver Name : Omar Hassan<br>"
                            + "Price : 80$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //------------------------------------------------------------------------------------------
                if (selectedDistrict.equals("El Amriya 2 District")) {
                    JFrame detailsFrame = new JFrame("Details for El Amriya 2 District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Amriya 2 District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El Amriya 2 District<br>"
                            + "Bus Number : 8<br>"
                            + "Pick-Up Time : 6.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : Two Hours<br>"
                            + "Driver Name : Amr Khamis<br>"
                            + "Price : 85$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
                //-----------------------------------------------------------------------------
                if (selectedDistrict.equals("El Al-Ajmi District")) {
                    JFrame detailsFrame = new JFrame("Details for El Al-Ajmi District");
                    detailsFrame.setSize(597, 616);
                    detailsFrame.setLocationRelativeTo(null); // Center the window

                    JPanel detailsPanel = new JPanel(new GridBagLayout());

                    JLabel detailsLabel = new JLabel("Details for El Al-Ajmi District");
                    detailsLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
                    detailsLabel.setHorizontalAlignment(SwingConstants.CENTER);

                    JLabel placeLabel = new JLabel("<html>Place : El Al-Ajmi District<br>"
                            + "Bus Number : 9<br>"
                            + "Pick-Up Time : 6.00 AM<br>"
                            + "Leaving Time : 3.00 PM<br>"
                            + "Destination : Alexandria National University<br>"
                            + "Duration ofTrip : Two Hours<br>"
                            + "Driver Name : Marwan Elsheikh<br>"
                            + "Price : 100$<br>"
                            + "1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4<br>"
                            + "5&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7&nbsp;&nbsp;&nbsp;&nbsp;8<br>"
                            + "9&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11&nbsp;&nbsp;&nbsp;&nbsp;12<br>"
                            + "13&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16<br>"
                            + "17&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;19&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;21</html>");

                    placeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24));
                    JPanel detailsPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    detailsPanel2.add(placeLabel);
                    detailsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Add some padding around the panel

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsLabel, gbc);

                    gbc.gridy = 1;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(detailsPanel2, gbc);

                    JButton bookButton = new JButton("Book");
                    bookButton.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size to 24
                    bookButton.setBackground(new Color(206, 183, 111, 255));

                    JTextField seatField = new JTextField(5);
                    seatField.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24

                    JLabel seatLabel = new JLabel("Seat Number: ");
                    seatLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24)); // Set the font size to 24
                    seatLabel.setForeground(Color.RED);

                    JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    bookPanel.add(seatLabel);
                    bookPanel.add(seatField);
                    bookPanel.add(bookButton);

                    gbc.gridy = 2;
                    gbc.insets = new Insets(10, 30, 10, 10);
                    detailsPanel.add(bookPanel, gbc);

                    bookButton.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            String seatNumberStr = seatField.getText();

                            try {
                                int seatNumber = Integer.parseInt(seatNumberStr);
                                bookSeat(seatNumber);

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid seat number!");
                            }
                        }
                    });
                    detailsFrame.add(detailsPanel); // Add the detailsPanel to the content pane of the detailsFrame
                    detailsFrame.setVisible(true);

                    frame.dispose(); // Close the old frame
                }
            }
        }
        );

        jLabel1 = new JLabel("Please select a district:");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel1.setForeground(Color.RED);

        JLabel makeBookingLabel = new JLabel("Make Booking");
        makeBookingLabel.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 30));
        makeBookingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(makeBookingLabel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 30, 10, 10); // Add some padding around the JComboBox
        panel.add(jLabel1, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding around the JButton
        panel.add(f, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding around the JButton
        panel.add(jButton1, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bus().setVisible(true);;
    }
}
