package rsa2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Library extends JFrame {

    private String name; // variable to store the user's name

    public Library() {
        super("Library");

        // Create a new JPanel for the components
        JPanel panel = new JPanel(new GridBagLayout()) {
            // Override the paintComponent method to draw the image as the background
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii1 = new ImageIcon("src/rsa2/library.png");
                Image img = ii1.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        // Set the content pane of the JFrame to the JPanel
        setContentPane(panel);

        // Set the size of the window
        setSize(474, 500);

        // Set the window to exit when closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the name label and text field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        nameLabel.setForeground(new Color(255, 255, 255));

        JTextField nameField = new JTextField(10);

        // Add the name label and text field to the panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 20, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        panel.add(nameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 20, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        panel.add(nameField, c);

        // Create the ID label and text field
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        idLabel.setForeground(new Color(255, 255, 255));
        JTextField idField = new JTextField(10);

        // Add the ID label and text field to the panel
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 20, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        panel.add(idLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 0, 0);
        c.anchor = GridBagConstraints.CENTER;
        panel.add(idField, c);

        // Create the next button
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(206, 183, 111, 255));
        nextButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save the name entered by the user
                name = nameField.getText();

                // Create a new JFrame for the next page
                JFrame nextFrame = new JFrame("Library ");

                // Set the size of the window
                nextFrame.setSize(800, 600);

                // Set the window to exit when closed
                nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create a new JPanel for the components
                JPanel panel = new JPanel(new GridBagLayout()) {
                    // Override the paintComponent method to draw the image as the background
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon ii1 = new ImageIcon("src/rsa2/library.png");
                        Image img = ii1.getImage();
                        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
                    }
                };

                // Set the content pane of the JFrame to the JPanel
                setContentPane(panel);

                // Set the size of the window
                setSize(474, 500);

                // Set the window to exit when closed
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JButton addButton = new JButton("Add Book");
                addButton.setBackground(new Color(206, 183, 111, 255));
                addButton.setFont(new Font("Times New Roman", Font.BOLD, 40));

// Add an ActionListener to the AddBook button
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Create a new JFrame for the Add Book page
                        JFrame addBookFrame = new JFrame("Add Book");
                        addBookFrame.setLocationRelativeTo(null);

                        // Set the size of the window
                        addBookFrame.setSize(415, 414);

                        // Set the window to exit when closed
                        addBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        // Add components to the Add Book frame
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                        // Add a label to the top of the frame
                        JLabel titleLabel = new JLabel("Add Book");
                        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
                        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        panel.add(titleLabel);

                        // Add some spacing between the title and the fields
                        panel.add(Box.createVerticalStrut(20));
                        // Add components to the panel
                        // Create label and text field components for Book Subject
                        JPanel subjectPanel = createLabelAndTextField("Book Subject:", 11);
                        JLabel subjectLabel = (JLabel) subjectPanel.getComponent(0);
                        JTextField subjectTextField = (JTextField) subjectPanel.getComponent(1);
                        panel.add(subjectPanel);

// Create label and text field components for Book Title
                        JPanel titlePanel2 = createLabelAndTextField("Book Title:", 14);
                        JLabel titleLabel2 = (JLabel) titlePanel2.getComponent(0);
                        JTextField titleTextField = (JTextField) titlePanel2.getComponent(1);
                        panel.add(titlePanel2);

// Create label and text field components for Author Name
                        JPanel authorPanel = createLabelAndTextField("Author Name:", 11);
                        JLabel authorLabel = (JLabel) authorPanel.getComponent(0);
                        JTextField authorTextField = (JTextField) authorPanel.getComponent(1);
                        panel.add(authorPanel);

// Create label and text field components for Year Publisher
                        JPanel yearPanel = createLabelAndTextField("Year Publisher:", 10);
                        JLabel yearLabel = (JLabel) yearPanel.getComponent(0);
                        JTextField yearTextField = (JTextField) yearPanel.getComponent(1);
                        panel.add(yearPanel);

// Create label and text field components for ISBN
                        JPanel isbnPanel = createLabelAndTextField("ISBN:", 20);
                        JLabel isbnLabel = (JLabel) isbnPanel.getComponent(0);
                        JTextField isbnTextField = (JTextField) isbnPanel.getComponent(1);
                        panel.add(isbnPanel);

                        // Add some less spacing between the components
                        panel.add(Box.createVerticalStrut(2));
                        JButton addButton = new JButton("Add");
                        addButton.setBackground(new Color(206, 183, 111, 255));
                        addButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        panel.add(addButton);

                        addButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String bookTitle = titleTextField.getText();
                                JOptionPane.showMessageDialog(null, "Book " + bookTitle + " has been added successfully!");
                            }
                        });
                        // Add the panel to the addBookFrame
                        addBookFrame.add(panel);

                        // Set the Add Book frame to be visible
                        addBookFrame.setVisible(true);

                    }

                    private JPanel createLabelAndTextField(String labelText, int fieldWidth) {
                        // Create a new panel to hold the label and text field
                        JPanel labelAndFieldPanel = new JPanel();
                        labelAndFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

                        // Create the label
                        JLabel label = new JLabel(labelText);
                        label.setFont(new Font("Times New Roman", Font.BOLD, 25));

                        // Create the text field
                        JTextField textField = new JTextField(fieldWidth);

                        // Add the label and text field to the panel
                        labelAndFieldPanel.add(label);
                        labelAndFieldPanel.add(textField);

                        return labelAndFieldPanel;
                    }
                });
//-------------------------------------------------------------------------------------------
                // Create the ViewBooks button
                JButton viewButton = new JButton("View Books");
                viewButton.setBackground(new Color(206, 183, 111, 255));
                viewButton.setFont(new Font("Times New Roman", Font.BOLD, 40));

                viewButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame addBookFrame = new JFrame("View Books");
                        addBookFrame.setLocationRelativeTo(null);

                        // Set the size of the window
                        addBookFrame.setSize(515, 371);

                        // Set the window to exit when closed
                        addBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        // Add components to the Add Book frame
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                        // Add a label to the top of the frame
                        JLabel titleLabel = new JLabel("View Books");
                        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
                        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                        panel.add(titleLabel);

//------------------------------------------------------------------------------------------
                        // Create a new panel to hold the buttons
                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

// Create a label to display the text "Choose Category"
                        JLabel chooseCategoryLabel = new JLabel("Choose Category : ");
                        chooseCategoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label horizontally
                        chooseCategoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        buttonPanel.add(chooseCategoryLabel);

// Set the layout of the panel to a vertical BoxLayout
                        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

// Create each button and add it to the panel
//--------------------------------------------------------------------------------------------
                        JButton CSButton = new JButton("Computer Science");
                        CSButton.setBackground(new Color(206, 183, 111, 255));
                        CSButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        CSButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"101", "Introduction to Computer Science", "John Smith", "978-0134672816", "$50.00"},
                                    {"102", "Data Structures and Algorithms", "Jane Doe", "978-0262033848", "$70.00"},
                                    {"103", "Operating Systems", "Bob Johnson", "978-1118063330", "$60.00"},
                                    {"104", "Computer Networks", "Alice Lee", "978-0132126953", "$80.00"},
                                    {"105", "Database Systems", "Tom Brown", "978-0132144988", "$90.00"},
                                    {"106", "Programming Language Pragmatics", "Michael L. Scott", "978-0124104099", "$75.00"},
                                    {"107", "Computer Architecture: A Quantitative Approach", "John L. Hennessy and David A. Patterson", "978-0128119051", "$85.00"},
                                    {"108", "Introduction to Cryptography", "Johannes Buchmann", "978-0387258804", "$70.00"},
                                    {"109", "Computer Graphics: Principles and Practice", "John F. Hughes,Andries van Dam, James D. Foley, Steven K. Feiner, and Kurt Akeley", "978-0321399526", "$95.00"},
                                    {"110", "Artificial Intelligence with Python", "Prateek Joshi", "978-1786464392", "$60.00"},
                                    {"111", "Computer Organization and Design", "David A. Patterson and John L. Hennessy", "978-0123747501", "$80.00"},
                                    {"112", "Theory of Computation", "Michael Sipser", "978-1133187790", "$65.00"},
                                    {"113", "Computer Vision: Algorithms and Applications", "Richard Szeliski", "978-1848829343", "$90.00"},
                                    {"114", "Computer Science Distilled: Learn the Art of Solving Computational Problems", "Wladston Ferreira Filho and Raimondo Pictet", "978-0997316029", "$40.00"},
                                    {"115", "Discrete Mathematics and Its Applications", "Kenneth H. Rosen", "978-1259676512", "$70.00"},
                                    {"116", "Computer Security: Principles and Practice", "William Stallings and Lawrie Brown", "978-0134794105", "$85.00"},
                                    {"117", "Data Mining: Concepts and Techniques", "Jiawei Han, Micheline Kamber, andJian Pei", "978-0123814791", "$95.00"}
                                };

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 101 && bookIdInt <= 117) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 101:
                                                        price = 50.00;
                                                        break;
                                                    case 102:
                                                        price = 70.00;
                                                        break;
                                                    case 103:
                                                        price = 60.00;
                                                        break;
                                                    case 104:
                                                        price = 80.00;
                                                        break;
                                                    case 105:
                                                        price = 90.00;
                                                        break;
                                                    case 106:
                                                        price = 75.00;
                                                        break;
                                                    case 107:
                                                        price = 85.00;
                                                        break;
                                                    case 108:
                                                        price = 70.00;
                                                        break;
                                                    case 109:
                                                        price = 95.00;
                                                        break;
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(CSButton);
//---------------------------------------------------------------------------------------
                        JButton DenButton = new JButton("Dentistry");
                        DenButton.setBackground(new Color(206, 183, 111, 255));
                        DenButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        DenButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"101", "Oral Anatomy, Histology and Embryology", "Barry K.B. Berkovitz, G. R. Holland, and Bernard J. Moxham", "978-0723436959", "$50.00"},
                                    {"102", "Clinical Periodontology and Implant Dentistry", "Niklaus P. Lang and Jan Lindhe", "978-1405160995", "$70.00"},
                                    {"103", "Oral Microbiology and Immunology", "Richard J. Lamont, George N. Hajishengallis, and Howard F. Jenkinson", "978-1555816729", "$60.00"},
                                    {"104", "Oral Radiology: Principles and Interpretation", "Stuart C. White and Michael J. Pharoah", "978-0323096331", "$80.00"},
                                    {"105", "Oral and Maxillofacial Surgery: An Objective-Based Textbook", "Jonathan Pedlar, John W. Frame, and David W. Williams", "978-1118915586", "$90.00"},
                                    {"106", "Contemporary Fixed Prosthodontics", "Stephen F. Rosenstiel, Martin F. Land, and Junhei Fujimoto", "978-0323080118", "$75.00"},
                                    {"107", "Pathways of the Pulp", "Kenneth M. Hargreaves and Louis H. Berman", "978-0323085144", "$85.00"},
                                    {"108", "Oral Medicine and Medically Complex Patients", "Peter B. Lockhart, Crispian Scully, and Michael A. Kahn", "978-0323548195", "$70.00"},
                                    {"109", "Endodontics: Principles and Practice", "Mahmoud Torabinejad, Richard E. Walton, and Ashraf F. Fouad", "978-0323359472", "$95.00"},
                                    {"110", "Pediatric Dentistry: Infancy Through Adolescence", "Arthur Nowak and John R. Christensen", "978-0323442626", "$60.00"},
                                    {"111", "Clinical Oral Anatomy and Physiology", "Thomas P. Brandt and Donald E. Isselhard", "978-0138000095", "$80.00"},
                                    {"112", "Dental Materials: Clinical Applications for Dental Assistants and Dental Hygienists", "Carol Dixon Hatrick, W. Stephan Eakle, and William F. Bird", "978-0323297423", "$65.00"},
                                    {"113", "Prosthodontic Treatment for Edentulous Patients: Complete Dentures and Implant-Supported Prostheses", "George A. Zarb, Charles L. Bolender, Carl O. Boucher, and Steven E. Eckert", "978-0323078443", "$90.00"},
                                    {"114", "Oral Pharmacology for the Dental Hygienist", "Mea A. Weinberg, Cheryl Westphal Theile, and James Burke Fine", "978-0132559928", "$40.00"},
                                    {"115", "Clinical Practice of the Dental Hygienist", "Esther M. Wilkins and Charlotte J. Wyche", "978-1496334374", "$70.00"},
                                    {"116", "Prevention of Oral Disease", "John J. Murray", "978-0192632798", "$85.00"},
                                    {"117", "Evidence-Based Dentistry for the Dental Hygienist", "Julie Frantsve-Hawley and Jill S. Nield-Gehrig", "978-1451193319", "$95.00"}
                                };

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 101 && bookIdInt <= 117) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 101:
                                                        price = 50.00;
                                                        break;
                                                    case 102:
                                                        price = 70.00;
                                                        break;
                                                    case 103:
                                                        price = 60.00;
                                                        break;
                                                    case 104:
                                                        price = 80.00;
                                                        break;
                                                    case 105:
                                                        price = 90.00;
                                                        break;
                                                    case 106:
                                                        price = 75.00;
                                                        break;
                                                    case 107:
                                                        price = 85.00;
                                                        break;
                                                    case 108:
                                                        price = 70.00;
                                                        break;
                                                    case 109:
                                                        price = 95.00;
                                                        break;
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(DenButton);
//-----------------------------------------------------------------------------------------
                        JButton PharmButton = new JButton("Pharmacy");
                        PharmButton.setBackground(new Color(206, 183, 111, 255));
                        PharmButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        PharmButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"101", "Pharmaceutical Chemistry", "Donald Cairns", "978-0199697397", "$50.00"},
                                    {"102", "Pharmacology: Connections to Nursing Practice", "Michael P. Adams and Carol Urban", "978-0135218330", "$70.00"},
                                    {"103", "Pharmaceutical Calculations", "Maria Glaucia Teixeira and Joel L. Zatz", "978-1285077469", "$60.00"},
                                    {"104", "Pharmacogenomics: An Introduction and Clinical Perspective", "Barbara A. Koenig, Teri E. Klein, and Russell A. Wilke", "978-0323188142", "$80.00"},
                                    {"105", "Pharmacy Practice and the Law", "Richard R. Abood", "978-1284089119", "$90.00"},
                                    {"106", "Pharmacotherapy: A Pathophysiologic Approach", "Joseph T. DiPiro, Robert L. Talbert, Gary C. Yee, Gary R. Matzke, Barbara G. Wells, and L. Michael Posey", "978-1260116816", "$75.00"},
                                    {"107", "Pharmacy Management: Essentials for All Practice Settings", "Shane P. Dess, David P. Zgarrick, and Greg L. Alston", "978-0071829632", "$85.00"},
                                    {"108", "Pharmacognosy", "Tyler, Varro E., Brady, Lynn R., and Robbers, James E.", "978-0781748596", "$70.00"},
                                    {"109", "Pharmaceutical Analysis", "David G. Watson", "978-0443074449", "$95.00"},
                                    {"110", "Drug Information: A Guide for Pharmacists", "Patrick M. Malone, Karen L. Kier, and John E. Stanovich", "978-0071833455", "$60.00"},
                                    {"111", "Pharmacotherapy Handbook", "Barbara G. Wells, Joseph T. DiPiro, Terry L. Schwinghammer, and Cecily V. DiPiro", "978-1259586439", "$80.00"},
                                    {"112", "Pharmacy Technician Certification Exam Review", "Lorraine C. Zentz", "978-0071845434", "$65.00"},
                                    {"113", "Clinical Pharmacokinetics and Pharmacodynamics: Concepts and Applications", "Malcolm Rowland and Thomas N. Tozer", "978-1496318749", "$90.00"},
                                    {"114", "Pharmaceutical Dosage Forms and Drug Delivery Systems", "Howard C. Ansel and Loyd V. Allen", "978-1451188766", "$40.00"},
                                    {"115", "Pharmaceutical Biotechnology: Concepts and Applications", "Gary Walsh", "978-1118571779", "$70.00"},
                                    {"116", "Pharmacy Ethics and Decision Making", "Joyce A. Generali", "978-1466552021", "$85.00"},
                                    {"117", "Pharmacotherapy Casebook: A Patient-Focused Approach", "Terry L. Schwinghammer, Julia M. Koehler, and Jill S. Borchert", "978-0071830539", "$95.00"}
                                };

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 101 && bookIdInt <= 117) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 101:
                                                        price = 50.00;
                                                        break;
                                                    case 102:
                                                        price = 70.00;
                                                        break;
                                                    case 103:
                                                        price = 60.00;
                                                        break;
                                                    case 104:
                                                        price = 80.00;
                                                        break;
                                                    case 105:
                                                        price = 90.00;
                                                        break;
                                                    case 106:
                                                        price = 75.00;
                                                        break;
                                                    case 107:
                                                        price = 85.00;
                                                        break;
                                                    case 108:
                                                        price = 70.00;
                                                        break;
                                                    case 109:
                                                        price = 95.00;
                                                        break;
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(PharmButton);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
                        JButton MedButton = new JButton("Medicine");
                        MedButton.setBackground(new Color(206, 183, 111, 255));
                        MedButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        MedButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"101", "Human Anatomy", "Henry Gray", "978-1912081019", "$50.00"},
                                    {"102", "Medical Physiology", "Rodney Rhoades and David R. Bell", "978-1119473594", "$70.00"},
                                    {"103", "Biochemistry", "Reginald H. Garrett and Charles M. Grisham", "978-1305577206", "$60.00"},
                                    {"104", "Medical Microbiology", "Patrick R. Murray, Ken S. Rosenthal, and Michael A. Pfaller", "978-0323673220", "$80.00"},
                                    {"105", "Pharmacology", "Kathleen M. Giacomini, Laurence L. Brunton, and John S. Lazo", "978-1259584732", "$90.00"},
                                    {"106", "Medical Immunology", "Gabriel Virella", "978-0815345116", "$75.00"},
                                    {"107", "Pathology", "Vinay Kumar, Abul K. Abbas, and Jon C. Aster", "978-0323353175", "$85.00"},
                                    {"108", "Medical Genetics", "Lynn B. Jorde, JohnC. Carey, and Michael J. Bamshad", "978-0323188357", "$95.00"},
                                    {"109", "Medical Neuroscience", "Alfonso Araque, Gordon M. Shepherd, and Darwin K. Berg", "978-0195396136", "$85.00"},
                                    {"110", "Medical Ethics", "Gregory Pence", "978-1259922190", "$60.00"},
                                    {"111", "Medical Statistics", "Brian S. Everitt and Geof H. Givens", "978-1439867666", "$80.00"},
                                    {"112", "Medical Terminology: A Programmed Learning Approach to the Language of Health Care", "Marjorie Canfield Willis", "978-1496385995", "$75.00"},
                                    {"113", "Medical Law and Ethics", "Jonathan Herring", "978-0198832062", "$90.00"},
                                    {"114", "Clinical Neuroanatomy Made Ridiculously Simple", "Stephen Goldberg", "978-1935660194", "$40.00"},
                                    {"115", "Medical Imaging: Essentials for Physicians", "Johannes Kirchner and Thomas H. Helbich", "978-3131573617", "$70.00"},
                                    {"116", "Medical Microbiology and Immunology: Examination and Board Review", "Warren Levinson", "978-1259644491", "$85.00"},
                                    {"117", "Medical Physiology: Principles for Clinical Medicine", "Rodney A. Rhoades and David R. Bell", "978-1609134273", "$95.00"}
                                };

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 101 && bookIdInt <= 117) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 101:
                                                        price = 50.00;
                                                        break;
                                                    case 102:
                                                        price = 70.00;
                                                        break;
                                                    case 103:
                                                        price = 60.00;
                                                        break;
                                                    case 104:
                                                        price = 80.00;
                                                        break;
                                                    case 105:
                                                        price = 90.00;
                                                        break;
                                                    case 106:
                                                        price = 75.00;
                                                        break;
                                                    case 107:
                                                        price = 85.00;
                                                        break;
                                                    case 108:
                                                        price = 70.00;
                                                        break;
                                                    case 109:
                                                        price = 95.00;
                                                        break;
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(MedButton);
//-----------------------------------------------------------------------------------------------------------------------------------------------------
                        JButton SIMButton = new JButton("Software Industry and MultiMedia");
                        SIMButton.setBackground(new Color(206, 183, 111, 255));
                        SIMButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        SIMButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"101", "Introduction to Computer Science", "John Smith", "978-0134672816", "$50.00"},
                                    {"102", "Data Structures and Algorithms", "Jane Doe", "978-0262033848", "$70.00"},
                                    {"103", "Operating Systems", "Bob Johnson", "978-1118063330", "$60.00"},
                                    {"104", "Computer Networks", "Alice Lee", "978-0132126953", "$80.00"},
                                    {"105", "Database Systems", "Tom Brown", "978-0132144988", "$90.00"},
                                    {"106", "Programming Language Pragmatics", "Michael L. Scott", "978-0124104099", "$75.00"},
                                    {"107", "Computer Architecture: A Quantitative Approach", "John L. Hennessy and David A. Patterson", "978-0128119051", "$85.00"},
                                    {"108", "Introduction to Cryptography", "Johannes Buchmann", "978-0387258804", "$70.00"},
                                    {"109", "Computer Graphics: Principles and Practice", "John F. Hughes,Andries van Dam, James D. Foley, Steven K. Feiner, and Kurt Akeley", "978-0321399526", "$95.00"},
                                    {"110", "Artificial Intelligence with Python", "Prateek Joshi", "978-1786464392", "$60.00"},
                                    {"111", "Computer Organization and Design", "David A. Patterson and John L. Hennessy", "978-0123747501", "$80.00"},
                                    {"112", "Theory of Computation", "Michael Sipser", "978-1133187790", "$65.00"},
                                    {"113", "Computer Vision: Algorithms and Applications", "Richard Szeliski", "978-1848829343", "$90.00"},
                                    {"114", "Computer Science Distilled: Learn the Art of Solving Computational Problems", "Wladston Ferreira Filho and Raimondo Pictet", "978-0997316029", "$40.00"},
                                    {"115", "Discrete Mathematics and Its Applications", "Kenneth H. Rosen", "978-1259676512", "$70.00"},
                                    {"116", "Computer Security: Principles and Practice", "William Stallings and Lawrie Brown", "978-0134794105", "$85.00"},
                                    {"117", "Data Mining: Concepts and Techniques", "Jiawei Han, Micheline Kamber, andJian Pei", "978-0123814791", "$95.00"}
                                };

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 101 && bookIdInt <= 117) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 101:
                                                        price = 50.00;
                                                        break;
                                                    case 102:
                                                        price = 70.00;
                                                        break;
                                                    case 103:
                                                        price = 60.00;
                                                        break;
                                                    case 104:
                                                        price = 80.00;
                                                        break;
                                                    case 105:
                                                        price = 90.00;
                                                        break;
                                                    case 106:
                                                        price = 75.00;
                                                        break;
                                                    case 107:
                                                        price = 85.00;
                                                        break;
                                                    case 108:
                                                        price = 70.00;
                                                        break;
                                                    case 109:
                                                        price = 95.00;
                                                        break;
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(SIMButton);
//--------------------------------------------------------------------------------------------------------------------------------------------------
                        JButton EngButton = new JButton("Engineering");
                        EngButton.setBackground(new Color(206, 183, 111, 255));
                        EngButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
                        EngButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object[][] data = {
                                    {"110", "Engineering Mechanics: Statics and Dynamics", "J. L. Meriam and L. G. Kraige", "978-0470614815", "$60.00"},
                                    {"111", "Introduction to Electrical Engineering", "Mulukutla S. Sarma", "978-0073380377", "$80.00"},
                                    {"112", "Engineering Thermodynamics", "Michael J. Moran, Howard N. Shapiro, and Daisie D. Boettner", "978-1118960880", "$65.00"},
                                    {"113", "Introduction to Materials Science for Engineers", "James F. Shackelford and William Alexander", "978-0133354737", "$90.00"},
                                    {"114", "Mechanics of Materials", "Russell C. Hibbeler", "978-0134326054", "$40.00"},
                                    {"115", "Introduction to Control Systems", "Dennis G. Zill and Michael R. Cullen", "978-1305074113", "$70.00"},
                                    {"116", "Fundamentals of Digital Logic and Microcontrollers", "M. Rafiquzzaman", "978-1118855799", "$85.00"},
                                    {"117", "Introduction to Robotics: Mechanics and Control", "John J. Craig", "978-0201543612", "$95.00"},
                                    {"118", "Mechanical Vibrations", "Singiresu S. Rao", "978-0132128193", "$75.00"},
                                    {"119", "Introduction to Aerospace Engineering with a Flight Test Perspective", "Stephen Corda", "978-0470395865", "$80.00"},
                                    {"120", "Introduction to Biomedical Engineering", "John Enderle, Susan Blanchard and Joseph Bronzino", "978-0122386626", "$95.00"},
                                    {"121", "Introduction to Chemical Engineering: Tools for Today and Tomorrow", "Kenneth A. Solen and John N. Harb", "978-0470885727", "$70.00"},
                                    {"122", "Statics and Strength of Materials for Architecture and Building Construction", "Barry S. Onouye and Kevin Kane", "978-0135079256", "$60.00"},
                                    {"123", "Introduction to Geotechnical Engineering", "Braja M. Das and Nagaratnam Sivakugan", "978-1305635180", "$85.00"},
                                    {"124", "Fundamentals of Materials Science and Engineering: An Integrated Approach", "William D. Callister Jr. and David G. Rethwisch", "978-1119405498", "$90.00"}};

                                // Create the column names for the table
                                Object[] columnNames = {"ID", "Title", "Author", "ISBN", "Price"};

                                // Create the JTable with the data and column names
                                JTable table = new JTable(data, columnNames);

                                // Add the table to a JScrollPane
                                JScrollPane scrollPane = new JScrollPane(table);

                                // Set the preferred size of the JScrollPane
                                scrollPane.setPreferredSize(new Dimension(750, 400));
                                addBookFrame.setSize(753, 506);

                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                // Create a panel to hold the bookButton and numberOfRoomsField components
                                JPanel bookPanel = new JPanel();
                                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS)); // Set the layout to vertical
                                bookPanel.add(new JLabel("Book ID:"));
                                JTextField bookIdField = new JTextField(10);
                                bookPanel.add(bookIdField);
                                bookPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                                JButton bookButton = new JButton("Book");
                                bookButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the book ID entered by the user
                                        String bookId = bookIdField.getText();
                                        // Update the table model to reflect the changes
                                        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
                                        try {
                                            int bookIdInt = Integer.parseInt(bookId);

                                            if (bookIdInt >= 110 && bookIdInt <= 124) {
                                                // Prompt the user to enter the number of days they want to borrow the book for
                                                String days = JOptionPane.showInputDialog(null, "For how many days do you want to borrow this book?");
                                                int daysInt = Integer.parseInt(days);
                                                double price = 0.0;
                                                switch (bookIdInt) {
                                                    case 110:
                                                        price = 60.00;
                                                        break;
                                                    case 111:
                                                        price = 80.00;
                                                        break;
                                                    case 112:
                                                        price = 65.00;
                                                        break;
                                                    case 113:
                                                        price = 90.00;
                                                        break;
                                                    case 114:
                                                        price = 40.00;
                                                        break;
                                                    case 115:
                                                        price = 70.00;
                                                        break;
                                                    case 116:
                                                        price = 85.00;
                                                        break;
                                                    case 117:
                                                        price = 95.00;
                                                        break;
                                                    case 118:
                                                        price = 75.00;
                                                        break;
                                                    case 119:
                                                        price = 80.00;
                                                        break;
                                                    case 120:
                                                        price = 95.00;
                                                        break;
                                                    case 121:
                                                        price = 70.00;
                                                        break;
                                                    case 122:
                                                        price = 60.00;
                                                        break;
                                                    case 123:
                                                        price = 85.00;
                                                        break;
                                                    case 124:
                                                        price = 90.00;
                                                        break;
                                                }

                                                // Calculate the total payment
                                                double totalPayment = daysInt * price;

                                                // Display a message dialog with the total payment
                                                JOptionPane.showMessageDialog(null, "The total payment for Book " + bookId + " is $" + totalPayment);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Book " + bookId + " doesn't exist!");
                                            }
                                        } catch (NumberFormatException ex) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid Book ID and number of days!");
                                        }
                                    }
                                });
                                bookPanel.add(bookButton);

                                // Create a new JFrame to display the table
                                JFrame frame = new JFrame("Computer Science Books");
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed

                                // Create a JPanel to hold the scrollPane and bookPanel
                                JPanel mainPanel = new JPanel();
                                mainPanel.add(scrollPane);
                                mainPanel.add(bookPanel);

                                frame.add(mainPanel); // Add the mainPanel to the frame
                                frame.pack(); // Resize the frame to fit thecontents
                                frame.setLocationRelativeTo(null); // Center the frame on the screen
                                frame.setVisible(true); // Show the frame

                            }
                        });
                        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add some vertical spacing
                        buttonPanel.add(EngButton);
//-----------------------------------------------------------------------------------------
// Add the button panel to the main panel of the frame
                        addBookFrame.add(buttonPanel);

// Set the Add Book frame to be visible
                        addBookFrame.setVisible(true);
                        //---------------------------------------------------------------
                    }
                });
                // Add the AddBook and ViewBooks buttons to the panel
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = 0;
                c.gridy = 0;
                c.gridwidth = 2;
                c.insets = new Insets(10, 20, 0, 20);
                c.anchor = GridBagConstraints.CENTER;
                panel.add(addButton, c);

                c.gridx = 0;
                c.gridy = 1;
                c.gridwidth = 2;
                c.insets = new Insets(20, 20, 0, 20);
                c.anchor = GridBagConstraints.CENTER;
                panel.add(viewButton, c);

                // Set the frame to be visible
                setVisible(true);
            }
        }
        );

        // Add the next button tothe panel
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.insets = new Insets(20, 20, 0, 20);
        c.anchor = GridBagConstraints.CENTER;

        panel.add(nextButton, c);

        // Set the frame to be visible
        setVisible(true);

    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        new Library().setVisible(true);
    }
}
