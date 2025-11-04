package com.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * This class creates a simple Java Swing application with a window (JFrame)
 * and a button (JButton). When the button is clicked, it logs a message
 * to the console.
 */
public class Main {

    /**
     * Initializes and displays the GUI components.
     */
    private static void createAndShowGUI() {
        // 1. Create the main frame (window)
        JFrame frame = new JFrame("Simple Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null); // Center the window

        // 2. Create a button
        JButton button = new JButton("Click Me!");

        // Enhance button style (optional but nice)
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(60, 140, 240)); // Blue background
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false); // Remove focus border

        // 3. Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            /**
             * This method is called every time the button is clicked.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // Log the message to the console
                System.out.println("Button Clicked! Logging event to console.");
                // Optionally, update the button text to confirm interaction
                button.setText("Clicked!");
            }
        });

        // 4. Set up the frame's content pane (using FlowLayout for simplicity)
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        panel.setBackground(new Color(240, 240, 240)); // Light grey background
        panel.add(button);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // 5. Display the window
        frame.setVisible(true);
    }

    /**
     * The main entry point for the application.
     */
    public static void main(String[] args) {
        // Swing applications must be run on the Event Dispatch Thread (EDT).
        // SwingUtilities.invokeLater ensures this happens safely.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

        // The original console output is still here, but runs before the GUI is fully
        // rendered.
        System.out.println("GUI initialization started (Main thread).");
    }
}
