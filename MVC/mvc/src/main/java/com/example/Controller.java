package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller component in the MVC pattern.
 * It manages the flow of data between the View (View.java) and the Model
 * (User.java).
 * It listens for user actions (like a button click) and handles the response.
 */
public class Controller implements ActionListener {
    private final View view;
    // The Model isn't stored here but is created upon interaction.
    // private User model; // Not necessary since we create a new User object per
    // login attempt

    /**
     * Constructor sets up the references and registers itself as the listener.
     */
    public Controller(View view) {
        this.view = view;
        // The controller registers itself to listen to the login button in the view
        this.view.addLoginListener(this);
    }

    /**
     * Handles action events (button clicks) from the View.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 1. Get data from the View
        String username = view.getUsername();
        String password = view.getPassword();

        // 2. Pass data to the Model (or create a Model instance with the data)
        User userAttempt = new User(username, password);

        // 3. Process the result using Model's business logic
        if (userAttempt.validate()) {
            // 4. Update the View based on the result
            view.updateMessage("Login Successful! Welcome, " + username + ".", false);
        } else {
            // 4. Update the View with an error message
            view.updateMessage("Login Failed. Invalid username or password.", true);
        }
    }
}
