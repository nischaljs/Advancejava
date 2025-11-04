package main.java.com.example;

import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.*;

/**
 * This class demonstrates the WindowListener interface to track
 * all major events in a JFrame's lifecycle.
 */
public class WindowEvents {

    /**
     * A custom implementation of WindowListener to log events to the console.
     */
    static class WindowLogger implements WindowListener {
        private final String windowName;

        public WindowLogger(String name) {
            this.windowName = name;
        }

        // 1. Called the first time a window is made visible.
        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Opened.");
        }

        // 2. Called when the user attempts to close the window from the system menu.
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Closing (Default action is HIDE or EXIT).");
            // Perform necessary cleanup here before closing
        }

        // 3. Called when the window has been closed as the result of a call to dispose.
        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Closed (Resources freed).");
        }

        // 4. Called when a window is changed from a normal to a minimized state.
        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Iconified (Minimized).");
        }

        // 5. Called when a window is changed from a minimized state to a normal state.
        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Deiconified (Restored).");
        }

        // 6. Called when the window is set to be the active window (receives focus).
        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Activated (Gained focus).");
        }

        // 7. Called when the window is no longer the active window (loses focus).
        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println(windowName + ": EVENT -> Window Deactivated (Lost focus).");
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Window Event Logger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Watch the console for Window Events (minimize, close, click outside, etc.)",
                SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(40, 40, 100));
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Attach the custom listener to the frame
        frame.addWindowListener(new WindowLogger("MainFrame"));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Swing applications must be run on the Event Dispatch Thread (EDT).
        // This lambda expression is the simplest way to represent the task.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
