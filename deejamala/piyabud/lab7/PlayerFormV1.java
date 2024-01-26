package deejamala.piyabud.lab7;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {
    protected JPanel topPanel, secondPanel, thirdPanel, forthPanel;
    protected JLabel nameLabel, nationallyLabel, dateOfBirthLabel;
    protected JTextField nameTextField;

    public PlayerFormV1(String title) {
        super(title);
    }

    protected void addComponents() {
        super.addComponents();
        nameLabel = new JLabel("Name:");
        nationallyLabel = new JLabel("Naionally:");
        dateOfBirthLabel = new JLabel("Date of Birth (eg.31-01-2005):");
        nameTextField = new JTextField(15);
        topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(nameLabel);
        topPanel.add(nameTextField);
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
