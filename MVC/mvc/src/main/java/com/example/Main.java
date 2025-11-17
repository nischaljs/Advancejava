package com.example;

import javax.swing.SwingUtilities;

/**
 * Main entry point for the MVC Login Application.
 * This class ensures the application is initialized and run on the Event
 * Dispatch Thread (EDT).
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Instantiate the View (The GUI)
            View view = new View();

            // 2. Instantiate the Controller and link it to the View
            // The Controller registers itself as the listener to the View's components
            new Controller(view);

            // 3. Display the View
            view.setVisible(true);
        });
    }
}
