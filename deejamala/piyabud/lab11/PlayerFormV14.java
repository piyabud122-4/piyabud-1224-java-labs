package deejamala.piyabud.lab11;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class PlayerFormV14 extends PlayerFormV13 {
    Player player;
    String filename;
    JMenu fillMenu;
    JRadioButtonMenuItem yesMenu, noMenu;

    public PlayerFormV14(String title) {
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
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.enableKeyboard();
        msw.setFrameFeatures();
    }

    @Override
    public void addMenus() {
        super.addMenus();
        fillMenu = new JMenu("Fill"); 
        yesMenu = new JRadioButtonMenuItem("Yes");
        noMenu = new JRadioButtonMenuItem("No", true);
        ButtonGroup fillGroup = new ButtonGroup();
        fillGroup.add(yesMenu);
        fillGroup.add(noMenu);
        fillMenu.add(yesMenu);
        fillMenu.add(noMenu);
        menuBar.add(fillMenu);        
    }

    @Override
    public void addListener() {
        super.addListener();
        noMenu.addActionListener(this);
        yesMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        fileChooser = new JFileChooser();
        if (source == customMenu) {
            Color newColor = JColorChooser.showDialog(this,"Color : ", nameTextField.getForeground());
            if (newColor != null) {
                nameTextField.setForeground(newColor);
                nationTextField.setForeground(newColor);
                dateOfBirthTextField.setForeground(newColor);
            } 
        } else if (source == openMenu) {
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
                } catch (IOException ex) {
                }
            }
        } else if (source == saveMenu) {
            if (noMenu.isSelected()) {
                int returnVal = fileChooser.showSaveDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filename = file.getPath();
                    JOptionPane.showMessageDialog(this, "Saving in file " + filename);

                    try (PrintWriter writer = new PrintWriter(file)) {
                        writer.println(nameTextField.getText() + " has nationality as " + nationTextField.getText() 
                        + " and was born on " + dateOfBirthTextField.getText() + ", has gender as " + gender + ", is a " 
                        + playerTypeBox.getSelectedItem() + " player, has hobbies as " + getSelectedHobbies() + " and plays " 
                        + sportList.getSelectedValuesList());
                    } catch (IOException ex) {
                    }
                }
            } else if (yesMenu.isSelected()) {
                try {
                    int returnVal = fileChooser.showSaveDialog(this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        filename = file.getPath();
                        JOptionPane.showMessageDialog(this, "Saving in file " + filename);
                        
                        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
                            outputStream.writeObject(player);
                        }
                    }
                    saveFormDataObject();
                    final FileOutputStream fileOut = new FileOutputStream(filename);
                    final ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(player);
                    out.close();
                    fileOut.close();
                } catch (Exception ex) {
                }
            }
        } else {
            super.actionPerformed(e);
        }
    }

    protected void saveFormDataObject() {
        String name = nameTextField.getText();
        String nationality = nationTextField.getText();
        String dob = dateOfBirthTextField.getText();
        String playerType = playerTypeBox.getSelectedItem().toString();
        ArrayList<String> hobbies = new ArrayList<>();
        ArrayList<String> sports = new ArrayList<>();
        int year = yearOfExperienceSlider.getValue();

        if (readingCheckBox.isSelected()) {
            hobbies.add("Reading ");
        } else if (browsingCheckBox.isSelected()) {
            hobbies.add("Browsing ");
        } else if (sleepingCheckBox.isSelected()) {
            hobbies.add("Sleeping ");
        } else if (travelingCheckBox.isSelected()) {
            hobbies.add("Traveling ");
        }

        List<String> selectedSports = sportList.getSelectedValuesList();
        int numSelected = selectedSports.size();
        for (int i = 0; i < numSelected; i++) {
            sports.add(selectedSports.get(i) + " ");
        }

        player = new Player(name, nationality, dob, playerType, hobbies, sports, year);
    }
}
