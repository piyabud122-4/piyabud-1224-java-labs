package deejamala.piyabud.lab10;

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
