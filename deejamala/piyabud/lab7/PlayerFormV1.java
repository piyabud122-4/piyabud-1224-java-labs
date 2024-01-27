package deejamala.piyabud.lab7;

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
