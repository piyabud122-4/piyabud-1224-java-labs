package deejamala.piyabud.lab9;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

import deejamala.piyabud.lab8.PlayerFormV5;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    public PlayerFormV6(String title) {
        super(title);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    public void addListener() {
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            
        }
    }
}
