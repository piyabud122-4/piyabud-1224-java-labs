package deejamala.piyabud.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import deejamala.piyabud.lab8.*;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    protected String gender;
    protected StringBuilder hobbies = new StringBuilder();

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
    }

    public void handleSubmitButton() {
        if (maleRadioButton.isSelected() == true) {
            gender = "male";
        } else if (femaleRadioButton.isSelected() == true) {
            gender = "female";
        }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            handleSubmitButton();
        } else if (e.getActionCommand().equals("Reset")) {
            handleResetButton();
        }
    }
}
