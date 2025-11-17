package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private final JTextField tUser = new JTextField(15);
    private final JPasswordField tPassword = new JPasswordField(15);
    private final JButton bLogin = new JButton("Login");
    private final JLabel lMessage = new JLabel("Please enter your credentials.");

    /**
     * Constructor sets up the JFrame and organizes the components.
     */
    public View() {
        // 1. Frame Setup
        setTitle("MVC Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Use BorderLayout for better structure
        setLayout(new BorderLayout(10, 10));

        // 2. Input Panel (uses GridLayout to stack components neatly)
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(tUser);

        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(tPassword);

        // 3. Button and Message Panel
        JPanel buttonAndMessagePanel = new JPanel(new BorderLayout());
        buttonAndMessagePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Center the login button in its own panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(bLogin);

        // Center the message label
        lMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lMessage.setForeground(Color.BLACK); // Default color

        buttonAndMessagePanel.add(lMessage, BorderLayout.NORTH);
        buttonAndMessagePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panels to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonAndMessagePanel, BorderLayout.SOUTH);

        // Finalize frame settings
        pack(); // Adjusts window size to fit components
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void addLoginListener(ActionListener listener) {
        bLogin.addActionListener(listener);
    }

    public String getUsername() {
        return tUser.getText();
    }

    public String getPassword() {
        return new String(tPassword.getPassword());
    }

    public void updateMessage(String message, boolean isError) {
        lMessage.setText(message);
        lMessage.setForeground(isError ? Color.RED : Color.BLUE);
    }

}
