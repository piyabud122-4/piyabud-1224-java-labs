package deejamala.piyabud.lab7;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV2 extends PlayerFormV1 {
    protected JPanel middlePanel;
    protected JLabel playerTypeLabel, noteLabel;
    protected JComboBox<String>playerTypeBox = new JComboBox<String>();
    protected JTextArea note;
    protected JScrollPane scrollPane;

    public PlayerFormV2(String title) {
        super(title);
    }

    public void addComponents() {
        super.addComponents();
        topPanel.removeAll();

        playerTypeLabel = new JLabel("Player Type: ");
        playerTypeBox = new JComboBox<String>();
        playerTypeBox.addItem("Beginner");
        playerTypeBox.addItem("Amateur");
        playerTypeBox.addItem("Professional");
        playerTypeBox.setSelectedIndex(1);

        noteLabel = new JLabel("Note: ");
        note = new JTextArea(3, 35);
        note.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
        scrollPane = new JScrollPane(note);

        topPanel.setLayout(new GridLayout(5,2));
        topPanel.add(nameLabel);
        topPanel.add(nameTextField);
        topPanel.add(nationalityLabel);
        topPanel.add(nationTextField);
        topPanel.add(dateOfBirthLabel);
        topPanel.add(dateOfBirthTextField);
        topPanel.add(genderLabel);
        topPanel.add(radioButtonPanel);
        topPanel.add(playerTypeLabel);
        topPanel.add(playerTypeBox);
        middlePanel = new JPanel(new GridLayout(2, 1));
        middlePanel.add(noteLabel);
        middlePanel.add(scrollPane);
        
        mainPanel.add(middlePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
