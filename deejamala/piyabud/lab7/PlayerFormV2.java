package deejamala.piyabud.lab7;

/* The class PlayerFormV2 extends from PlayerFormV1.
 * The title of the program should be “Player Form V2”.
 * Add the label "Player Type:" and a combo box for selecting the type of player, 
 * which includes options "Beginner", "Amateur", and "Professional". 
 * The combo box should not be editable, and the default type shown should be set to "Amateur".
 * Add the label “Note:” and the text area with 3 rows and 35 columns.
 * Include the scroll pane and add the text area in that scroll pane.
 * Initialize the text area with the content as "Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, 
 * Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F." The text should be wrapped in the textarea.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

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

        topPanel.setLayout(new GridLayout(5, 2));
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
