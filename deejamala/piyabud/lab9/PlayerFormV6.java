package deejamala.piyabud.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import deejamala.piyabud.lab8.*;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            note.append(nameTextField + " has nationally as " + nationTextField);
        }
    }
}
