package rsa2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener {

    private JPanel loginPanel;
    private JPanel signUpPanel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel signUpPasswordLabel;
    private JTextField nameField;
    private JTextField idField;
    private JPasswordField signUpPasswordField;
    private JButton signUpConfirmButton;
    private CardLayout cardLayout;

    public Login() {
        super("University Login Gate");
        // Create GUI components for login panel
        usernameLabel = new JLabel(" Username:");
        usernameLabel.setBounds(655, 150, 200, 30);
        usernameLabel.setForeground(new Color(0, 0, 0));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        passwordLabel = new JLabel(" Password:");
        passwordLabel.setBounds(655, 150, 200, 30);
        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        usernameField = new JTextField(40);
        passwordField = new JPasswordField(40);
        loginButton = new JButton("Login");
        loginButton.setBounds(655, 150, 200, 30);
        loginButton.setForeground(new Color(0, 0, 0));
        loginButton.setFont(new Font("Calibri", Font.BOLD, 30));
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(655, 150, 200, 30);
        signUpButton.setForeground(new Color(0, 0, 0));
        signUpButton.setFont(new Font("Calibri", Font.BOLD, 30));

        // Create GUI components for sign-up panel
        nameLabel = new JLabel(" Name:");
        nameLabel.setBounds(655, 150, 200, 30);
        nameLabel.setForeground(new Color(0, 0, 0));
        nameLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        idLabel = new JLabel(" ID:");
        idLabel.setBounds(655, 150, 200, 30);
        idLabel.setForeground(new Color(0, 0, 0));
        idLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        signUpPasswordLabel = new JLabel(" Password:");
        signUpPasswordLabel.setBounds(655, 150, 200, 30);
        signUpPasswordLabel.setForeground(new Color(0, 0, 0));
        signUpPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        nameField = new JTextField(20);
        idField = new JTextField(20);
        signUpPasswordField = new JPasswordField(20);
        signUpConfirmButton = new JButton("Sign Up");

        // Create panels for login and sign-up pages
        loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(signUpButton);

        signUpPanel = new JPanel(new GridLayout(4, 2));
        signUpPanel.add(nameLabel);
        signUpPanel.add(nameField);
        signUpPanel.add(idLabel);
        signUpPanel.add(idField);
        signUpPanel.add(signUpPasswordLabel);
        signUpPanel.add(signUpPasswordField);
        signUpPanel.add(new JLabel()); // Empty label for spacing
        signUpPanel.add(signUpConfirmButton);

        // Add action listeners to buttons
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        signUpConfirmButton.addActionListener(this);

        // Create and set card layout
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        add(loginPanel, "login");
        add(signUpPanel, "signup");

        // Set window properties
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Get input values
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Define valid usernames and passwords
            Map<String, String> validCredentials = new HashMap<>();
            validCredentials.put("Omnia", "1");
            validCredentials.put("Aisha", "2");
            validCredentials.put("Gehad", "3");

            // Validate input
            if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");

                // Redirect user to dashboard
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (e.getSource() == signUpButton) {
            // Switch to sign-up panel
            cardLayout.show(this.getContentPane(), "signup");
        } else if (e.getSource() == signUpConfirmButton) {
            // Get input values
            String name = nameField.getText();
            String id = idField.getText();
            String password = new String(signUpPasswordField.getPassword());

            // TODO: Implement sign up logic here
            // Display success message
            JOptionPane.showMessageDialog(this, "Sign up successful!");

            // Hide the login page
            setVisible(false);

            // Create and show the dashboard page
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new Login();
    }

    class Dashboard extends JFrame implements ActionListener {

        private JButton button1;
        private JButton button2;
        private JButton button3;
        private JButton button4;
        private JButton button5;
        private JButton button6;
        private JButton button7;
        private JButton button8;

        public Dashboard() {
            super("Dashboard");

// Set layout
            setLayout(new BorderLayout());
            JLabel welcomeLabel = new JLabel("Welcome to Alexandria National University!");
            welcomeLabel.setFont(new Font("Rockwell Extra bold", Font.BOLD, 44));
            welcomeLabel.setForeground(Color.BLACK);
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(welcomeLabel, BorderLayout.NORTH);

// Create nested JPanel with GridLayout
            JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

// Create GUI components
            button1 = new JButton("Student");
            button2 = new JButton("Instructor");
            button3 = new JButton("Library");
            button4 = new JButton("Registration");
            button5 = new JButton("Department");
            button6 = new JButton("Bus");
            button7 = new JButton("Hostel");
            button8 = new JButton("About Us");

// Set preferred size and font for buttons
            Dimension buttonSize = new Dimension(250, 100);
            Font buttonFont = new Font("Arial", Font.BOLD, 36);
            Color myColor = new Color(206, 183, 111, 255); // Creates an orange color
            button1.setBackground(myColor);
            button2.setBackground(myColor);
            button3.setBackground(myColor);
            button4.setBackground(myColor);
            button5.setBackground(myColor);
            button6.setBackground(myColor);
            button7.setBackground(myColor);
            button8.setBackground(myColor);
            button1.setPreferredSize(buttonSize);
            button2.setPreferredSize(buttonSize);
            button3.setPreferredSize(buttonSize);
            button4.setPreferredSize(buttonSize);
            button5.setPreferredSize(buttonSize);
            button6.setPreferredSize(buttonSize);
            button7.setPreferredSize(buttonSize);
            button8.setPreferredSize(buttonSize);
            button1.setFont(buttonFont);
            button2.setFont(buttonFont);
            button3.setFont(buttonFont);
            button4.setFont(buttonFont);
            button5.setFont(buttonFont);
            button6.setFont(buttonFont);
            button7.setFont(buttonFont);
            button8.setFont(buttonFont);

// Add components to nested JPanel
            buttonPanel.add(button1);
            buttonPanel.add(button2);
            buttonPanel.add(button3);
            buttonPanel.add(button4);
            buttonPanel.add(button5);
            buttonPanel.add(button6);
            buttonPanel.add(button7);
            buttonPanel.add(button8);

// Add nested JPanel to JFrame
            add(buttonPanel, BorderLayout.CENTER);
            // Add action listeners to buttons
            button1.addActionListener(this);
            button2.addActionListener(this);
            button3.addActionListener(this);
            button4.addActionListener(this);
            button5.addActionListener(this);
            button6.addActionListener(this);
            button7.addActionListener(this);
            button8.addActionListener(this);

            // Set window properties
            pack();
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create and display the new page or class here
                    Library libraryPage = new Library();
                    libraryPage.setVisible(true);
                }
            });
  button4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create and display the new page or class here
                    Registration RegPage = new Registration();
                    RegPage.setVisible(true);
                }
            });
            button6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create and display the new page or class here
                    Bus busPage = new Bus();
                    busPage.setVisible(true);
                }
            });

            button7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create and display the new page or class here
                    Hostel hostelPage = new Hostel();
                    hostelPage.setVisible(true);
                }
            });

            button8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // create and display the new page or class here
                    AboutUs aboutUsPage = new AboutUs();
                    aboutUsPage.setVisible(true);
                }
            });
        }

        public void actionPerformed(ActionEvent e) {
            // Handle button clicks here
        }

    }
}
