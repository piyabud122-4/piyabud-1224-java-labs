package deejamala.piyabud.lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayerFormV10 extends PlayerFormV9 {
    public PlayerFormV10(String title) {
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
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener();
        redMenu.addActionListener(this);
        greenMenu.addActionListener(this);
        blueMenu.addActionListener(this);
        sixteenMenu.addActionListener(this);
        twentyMenu.addActionListener(this);
        twentyfourMenu.addActionListener(this);
        newMenu.addActionListener(this);
        openMenu.addActionListener(this);
        saveMenu.addActionListener(this);
        exitMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        if (source == redMenu) {
            nameTextField.setForeground(Color.RED);
            nationTextField.setForeground(Color.RED);
            dateOfBirthTextField.setForeground(Color.RED);
        } else if (source == greenMenu) {
            nameTextField.setForeground(Color.GREEN);
            nationTextField.setForeground(Color.GREEN);
            dateOfBirthTextField.setForeground(Color.GREEN);
        } else if (source == blueMenu) {
            nameTextField.setForeground(Color.BLUE);
            nationTextField.setForeground(Color.BLUE);
            dateOfBirthTextField.setForeground(Color.BLUE);
        } else if (source == sixteenMenu) {
            nameTextField.setFont(new Font("Serif",  Font.BOLD, 16));
            nationTextField.setFont(new Font("Serif", Font.BOLD, 16));
            dateOfBirthTextField.setFont(new Font("Serif", Font.BOLD, 16));
        } else if (source == twentyMenu) {
            nameTextField.setFont(new Font("Serif", Font.BOLD, 20));
            nationTextField.setFont(new Font("Serif", Font.BOLD, 20));
            dateOfBirthTextField.setFont(new Font("Serif", Font.BOLD, 20));
        } else if (source == twentyfourMenu) {
            nameTextField.setFont(new Font("Serif", Font.BOLD, 24));
            nationTextField.setFont(new Font("Serif", Font.BOLD, 24));
            dateOfBirthTextField.setFont(new Font("Serif", Font.BOLD, 24));
        }
        
        if (source == newMenu) {
            JOptionPane.showMessageDialog(this, "You click menu New");
        } else if (source == openMenu) {
            JOptionPane.showMessageDialog(this, "You click menu Open");
        } else if (source == saveMenu) {
            JOptionPane.showMessageDialog(this, "You click menu Save");
        } else if (source == exitMenu) {
            System.exit(1);
        }
    }
}
