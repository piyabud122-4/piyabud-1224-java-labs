package deejamala.piyabud.lab7;

/* The class MySimpleWindow extends from class JFrame.
 * Declare four variables, two panels and two buttons.
 * Implement the protected void addComponents() to add two buttons whose names are “Reset” and “Submit”.
 * Implement method protected  protected void setFrameFeatures() which performs these tasks
 * - Set the window location at the center of the screen
 * - Set the window visible
 * - Exit the application using the System exit method when the user 	initiates a "close" on this frame
 * - Pack all components of the frame.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import javax.swing.*;
import java.awt.*;

public class MySimpleWindow extends JFrame {
    protected JPanel buttonPanel, mainPanel;
    protected JButton resetButton,submitButton;

    public MySimpleWindow(String title) {
        super(title);
    }

    protected void addComponents() {
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    protected void setFrameFeatures() {
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
