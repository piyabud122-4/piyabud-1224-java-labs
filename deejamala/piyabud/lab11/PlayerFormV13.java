package deejamala.piyabud.lab11;

/* The class PlayerFormV13 extends from PlayerFormV12.
 * When the user selects the Save in File Menu, the program should read the data from the form to the chosen file. 
 * The data is saved in the same format as the data showing in the dialog when the user clicks the submit button.
 * 
 * When the user selects the Open in File Menu, the program should read the data from the selected file 
 * and show the message read from the file.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.io.*;
import javax.swing.*;
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
        if (source == openMenu) {
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (source == saveMenu) {
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filename = file.getPath();
                JOptionPane.showMessageDialog(this, "Saving in file " + filename);

                getSelectedGender();
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println(nameTextField.getText() + " has nationality as " + nationTextField.getText() 
                    + " and was born on " + dateOfBirthTextField.getText() + ", has gender as " + gender  + ", is a " 
                    + playerTypeBox.getSelectedItem() + " player, has hobbies as " + getSelectedHobbies() + " and plays " 
                    + sportList.getSelectedValuesList());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            super.actionPerformed(e);
        }
    }

    protected void getSelectedGender() {
        if (maleRadioButton.isSelected() == true) {
            gender = "male";
        } else if (femaleRadioButton.isSelected() == true) {
            gender = "female";
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
