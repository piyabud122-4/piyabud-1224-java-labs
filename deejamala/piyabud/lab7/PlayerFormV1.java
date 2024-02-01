package deejamala.piyabud.lab7;

/* The class PlayerFormV1 extends from class MySimpleWindow.
 * The title of the program is set as “Player Form V1”.
 * Declare variables as protected variables.
 * Interface:
 * The laft part contains JLabel and then the right part contains JTextField whose length is 15.
 * The first line contains the label which it is set as “Name:”
 * The second line contains the label which it is set as “Nationality:”
 * The third line contains the label which it is set as “Date of Birth (eg.,31-01-2005):”
 * The fourth line contains the radio buttons which are “Male” and “Female”.
 * Allow a user to choose only one radio button at a time and the “Female” button should be selected by default.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {
    protected JPanel topPanel, radioButtonPanel;
    protected JLabel nameLabel, nationalityLabel, dateOfBirthLabel, genderLabel;
    protected JTextField nameTextField, nationTextField, dateOfBirthTextField;
    protected JRadioButton maleRadioButton, femaleRadioButton;
    protected ButtonGroup radioButtonGroup;

    public PlayerFormV1(String title) {
        super(title);
    }

    protected void addComponents() {
        super.addComponents();
        nameLabel = new JLabel("Name: ");
        nameTextField = new JTextField(15);
        nationalityLabel = new JLabel("Nationality: ");
        nationTextField = new JTextField(15); 
        dateOfBirthLabel = new JLabel("Date of Birth (eg.31-01-2005): ");
        dateOfBirthTextField = new JTextField(15);

        genderLabel = new JLabel("Gender: ");
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female", true);
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonPanel = new JPanel();
        radioButtonPanel.add(maleRadioButton);
        radioButtonPanel.add(femaleRadioButton);

        topPanel = new JPanel(new GridLayout(4, 2));
        topPanel.add(nameLabel);
        topPanel.add(nameTextField);
        topPanel.add(nationalityLabel);
        topPanel.add(nationTextField);
        topPanel.add(dateOfBirthLabel);
        topPanel.add(dateOfBirthTextField);
        topPanel.add(genderLabel);
        topPanel.add(radioButtonPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
