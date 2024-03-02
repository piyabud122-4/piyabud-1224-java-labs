package deejamala.piyabud.lab11;

import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PlayerFormV13 extends PlayerFormV12 {
    public PlayerFormV13(String title) {
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
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.enableKeyboard();
        msw.setFrameFeatures();
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

                try {
                    FileReader reader = new FileReader(filename);
                    BufferedReader r = new BufferedReader(reader);
                    StringBuilder message = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        message.append(line).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, "Data read from file " + filename + " is\n" + message.toString());
                    reader.close();
                } catch (IOException ex) {
                }
            }
        } else if (source == saveMenu) {
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getPath();
                JOptionPane.showMessageDialog(this, "Saving in file " + filename);

                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println(nameTextField.getText() + " has nationality as " + nationTextField.getText() 
                    + " and was born on " + dateOfBirthTextField.getText() + ", has gender as " + gender + ", is a " 
                    + playerTypeBox.getSelectedItem() + " player, has hobbies as " + getSelectedHobbies() + " and plays " 
                    + sportList.getSelectedValuesList());
                } catch (IOException ex) {
                }
            }
        } else {
            super.actionPerformed(e);
        }
    }

    protected String getSelectedHobbies() {
        StringBuilder hobbies = new StringBuilder();
        if (readingCheckBox.isSelected()) {
            hobbies.append("Reading ");
        }
        if (browsingCheckBox.isSelected()) {
            hobbies.append("Browsing ");
        }
        if (sleepingCheckBox.isSelected()) {
            hobbies.append("Sleeping ");
        }
        if (travelingCheckBox.isSelected()) {
            hobbies.append("Traveling ");
        }
        return hobbies.toString().trim();
    }
}
