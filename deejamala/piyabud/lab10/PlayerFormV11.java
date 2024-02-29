package deejamala.piyabud.lab10;

/* The class PlayerFormV11 extends from PlayerFormV10.
 * Overrides the Implement method addMenus() so the menu item “Custom” is added under the menu “Color”.  
 * Overrides the method addListeners() such that the appropriate listeners are added to the menu item “Custom”.
 * Overrides the method actionPerformed() such that when the user selects the menu item “Custom”, 
 * the color chooser dialog is show. In the dialog the color on the bottom should be the color of the current color of the text field.
 * When the user chooses a new color, apply that color to all text fields “Name”, “Nationality”, and “Date of Birth”.
 * When the “Open” menu item is selected the program displays the open file dialog for the user to select a file to open. 
 * When the user completes choosing the file, a message dialog is shown indicating the name and path of the file that is open.
 * When the “Save” menu item is selected the program displays the save file dialog for the user to type in or select a file to save. 
 * When the user completes typing in or choosing the file, a message dialog is shown indicating the name and path of the file that is saved.
 * Implement a method called enableKeyboard(). The method will add accelerator keys and mnemonic keys.
 * Set a mnemonic key to the file menu. Set the letter “f” as a shortcut.
 * Set mnemonic keys to the menus “New”, “Open”, “Save”, and “Exit” using keys “n”, “o”, “s”, and “x” respectively.
 * Set the accelerator keys to the menu New”, “Open”, “Save”, and “Exit” using keys “n”, “o”, “s”, and “x” respectively.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;

public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customMenu;
    protected JFileChooser fileChooser;

    public PlayerFormV11(String title) {
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
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.enableKeyboard();
        msw.setFrameFeatures();
    }

    @Override
    public void addMenus() {
        super.addMenus();
        customMenu = new JMenuItem("Custom");
        colorMenu.add(customMenu);
    }

    @Override
    public void addListener() {
        super.addListener();
        customMenu.addActionListener(this);
    }

    public void enableKeyboard() {
        fileMenu.setMnemonic('f');
        
        newMenu.setMnemonic('n');
        newMenu.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));

        openMenu.setMnemonic('o');
        openMenu.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));

        saveMenu.setMnemonic('s');
        saveMenu.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));

        exitMenu.setMnemonic('q');
        exitMenu.setAccelerator(KeyStroke.getKeyStroke('Q', ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        fileChooser = new JFileChooser();
        if (source == customMenu) {
            Color newColor = JColorChooser.showDialog(this,"Color : ", nameTextField.getForeground());
            if (newColor != null) {
                nameTextField.setForeground(newColor);
                nationTextField.setForeground(newColor);
                dateOfBirthTextField.setForeground(newColor);
            } 
        } else if (source == openMenu) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getPath();
                JOptionPane.showMessageDialog(this, "Opening file " + filename);
            }
        } else if (source == saveMenu) {
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getPath();
                JOptionPane.showMessageDialog(this, "Saving in file " + filename);
            }
        } else {
            super.actionPerformed(e);
        }
    }
}
