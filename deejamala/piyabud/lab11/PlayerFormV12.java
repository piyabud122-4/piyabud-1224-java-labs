package deejamala.piyabud.lab11;

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
