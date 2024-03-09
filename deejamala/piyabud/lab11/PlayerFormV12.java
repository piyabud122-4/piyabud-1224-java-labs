package deejamala.piyabud.lab11;

/* The class PlayerFormV12 extends from PlayerFormV11.
 * This program has function Check for empty field when the user enters data in the text field.
 * If the name is empty, when the user enters empty data in the text field show the dialog with 
 * the message "Please enter some data in Name".
 * The name text field is in focus and the next component is disabled.
 * If the name is not empty, there will be the dialog showing the message "Name is changed to <data>".
 * 
 * If the nationality is empty, when the user enters empty data in the text field show the dialog with 
 * the message "Please enter some data in Nationality".
 * The nationality text field is in focus and the next component is disabled.
 * 
 * Check if the date of birth is input in the correct format, which is in the format dd-MM-yyyy, 
 * where dd is date of the month, MM is month of the year and yyyy is the year.
 * If the entered date is empty or not in the format yyyy-MM-dd, the dialog with 
 * the message “Please enter a valid date in Date of Birth”.
 * If the entered date is in the format dd-MM-yyyy, the dialog with 
 * the message “Date of Birth is changed to <dd>-<MM>-<yyyy>”.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import deejamala.piyabud.lab10.PlayerFormV11;

public class PlayerFormV12 extends PlayerFormV11 {
    public PlayerFormV12(String title) {
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
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.enableKeyboard();
        msw.setFrameFeatures();
    }

    public void handleTextField(JTextField tf) {
        if (tf == dateOfBirthTextField) {
            handleDateTextField(tf);
        } else if (tf == nameTextField) {
            handleNormalTextField(nameTextField, nationTextField);
        } else if (tf == nationTextField) {
            handleNormalTextField(nationTextField, dateOfBirthTextField);
        }
    }

    public void handleDateTextField(JTextField tf) {
        String inputDate = tf.getText().trim();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateOfBirth = LocalDate.parse(inputDate, formatter);
            String formattedDate = dateOfBirth.format(formatter);
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + formattedDate);
        } catch (DateTimeParseException e){
            JOptionPane.showMessageDialog(this, "Please enter a valid date in Date of Birth");
        }
    }

    public void handleNormalTextField(JTextField textField, JTextField nextComponent) {
        String data = textField.getText().trim();
        String fieldName = (textField == nameTextField) ? "Name" : "Nationality";
        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + fieldName);
            textField.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, fieldName + " is changed to " + data);
            nextComponent.setEnabled(true);
        }
    }
}
