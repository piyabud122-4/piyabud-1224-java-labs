package deejamala.piyabud.lab9;

/* The class PlayerFormV6 extends from PlayerFormV5 and implements ActionListener.
 * When the user enters the top three text fields and clicks the Submit button, 
 * the program displays the message in the message dialog.
 * The program displays the values of name, nationality, date of birth, gender, player type, hobbies, and sports in the format.
 * When the user clicks the Reset button, the program resets the name, nationality, and date of birth text fields.
 * When the user changes any text field and press Enter on the keyboard, 
 * the program displays the message dialog showing that text field is updated, 
 * in the format “<Textfield Name> is changed to <Textfield Value>”.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import deejamala.piyabud.lab8.*;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    protected String gender;

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
        resetButton.addActionListener(this);
        nameTextField.addActionListener(this);
        nationTextField.addActionListener(this);
        dateOfBirthTextField.addActionListener(this);
    }

    public void handleSubmitButton() {
        if (maleRadioButton.isSelected() == true) {
            gender = "male";
        } else if (femaleRadioButton.isSelected() == true) {
            gender = "female";
        }

        StringBuilder hobbies = new StringBuilder();
        if (readingCheckBox.isSelected() == true) {
            hobbies.append("Reading" + " ");
        } 
        if (browsingCheckBox.isSelected() == true) {
            hobbies.append("Browsing" + " ");
        } 
        if (sleepingCheckBox.isSelected() == true) {
            hobbies.append("Sleeping" + " ");
        } 
        if (travelingCheckBox.isSelected() == true) {
            hobbies.append("Traveling" + " ");
        }
        JOptionPane.showMessageDialog(this, nameTextField.getText() + " has nationality as " + nationTextField.getText() 
        + " and was born on " + dateOfBirthTextField.getText() + ", has gender as " + gender + ", is a " + playerTypeBox.getSelectedItem() 
        + " player, has hobbies as " + hobbies + " and plays " + sportList.getSelectedValuesList());
    }

    public void handleResetButton() {
        nameTextField.setText("");
        nationTextField.setText("");
        dateOfBirthTextField.setText("");
    }
    
    public void handleTextField(JTextField src) {
        if (src == nameTextField) {
            JOptionPane.showMessageDialog(this, "Name is changed to " + nameTextField.getText());
        } else if (src == nationTextField) {
            JOptionPane.showMessageDialog(this, "Nationality is changed to " + nationTextField.getText());
        } else if (src == dateOfBirthTextField) {
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + dateOfBirthTextField.getText());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {
            handleResetButton();
        } else if (src instanceof JTextField) {
            handleTextField((JTextField) src);
        }
    }    
}
