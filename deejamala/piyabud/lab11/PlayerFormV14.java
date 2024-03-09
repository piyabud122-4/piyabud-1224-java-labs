package deejamala.piyabud.lab11;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class PlayerFormV14 extends PlayerFormV13 {
    Player player, readPlayer;
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
        if (source == openMenu) {
            if (noMenu.isSelected()) {
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
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (yesMenu.isSelected()) {
                int returnVal = fileChooser.showOpenDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        filename = file.getPath();
                        JOptionPane.showMessageDialog(this, "Opening file " + filename);   
                        
                        final FileInputStream fileIn = new FileInputStream(filename);
                        final ObjectInputStream in = new ObjectInputStream(fileIn);
                        readPlayer = (Player) in.readObject();
                        nameTextField.setText(readPlayer.getName());
                        nationTextField.setText(readPlayer.getNationality());
                        dateOfBirthTextField.setText(readPlayer.getDob());
                        if (readPlayer.getGender().equals("male")) {
                            maleRadioButton.setSelected(true);
                        } else {
                            femaleRadioButton.setSelected(true);
                        }
                        playerTypeBox.setSelectedItem(readPlayer.getPlayerType());
                        readingCheckBox.setSelected(readPlayer.getHobbies().contains(readingCheckBox.getText()));
                        browsingCheckBox.setSelected(readPlayer.getHobbies().contains(browsingCheckBox.getText()));
                        sleepingCheckBox.setSelected(readPlayer.getHobbies().contains(sleepingCheckBox.getText()));
                        travelingCheckBox.setSelected(readPlayer.getHobbies().contains(travelingCheckBox.getText()));
                        sportList.clearSelection();
                        ListModel<String> sportsModel = sportList.getModel();
                        for (String sport : readPlayer.getSports()) {
                            for (int i = 0; i < sportsModel.getSize(); i++) {
                                if (sportsModel.getElementAt(i).equals(sport)) {
                                    sportList.addSelectionInterval(i, i);
                                }
                            }
                        }
                        yearOfExperienceSlider.setValue(readPlayer.getYear());
                        JOptionPane.showMessageDialog(this, "Data read from file " + filename + " is\n" + readPlayer.getName() 
                            + " has nationality as " + readPlayer.getNationality() + " and was born on " + readPlayer.getDob() 
                            + ", has gender as " + readPlayer.getGender() + ", is a " + readPlayer.getPlayerType() + 
                            " player, has hobbies as " + readPlayer.getHobbies() + " and plays " + readPlayer.getSports() +
                            " and has experience years as " + readPlayer.getYear());
                        in.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else if (source == saveMenu) {
            if (noMenu.isSelected()) {
                int returnVal = fileChooser.showSaveDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    filename = file.getPath();
                    JOptionPane.showMessageDialog(this, "Saving in file " + filename);

                    getSelectedGender();
                    try (PrintWriter writer = new PrintWriter(file)) {
                        writer.println(nameTextField.getText() + " has nationality as " + nationTextField.getText() 
                        + " and was born on " + dateOfBirthTextField.getText() + ", has gender as " + gender + ", is a " 
                        + playerTypeBox.getSelectedItem() + " player, has hobbies as " + getSelectedHobbies() + " and plays " 
                        + sportList.getSelectedValuesList());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (yesMenu.isSelected()) {
                int returnVal = fileChooser.showSaveDialog(this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fileChooser.getSelectedFile();
                        filename = file.getPath();
                        JOptionPane.showMessageDialog(this, "Saving in file " + filename);

                        saveFormDataObject();
                        final FileOutputStream fileOut = new FileOutputStream(filename);
                        final ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(player);
                        out.close();
                        fileOut.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
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
        String gender = maleRadioButton.isSelected() ? "male" : "female";
        ArrayList<String> hobbies = new ArrayList<>();
        ArrayList<String> sports = new ArrayList<>();
        int year = yearOfExperienceSlider.getValue();

        if (readingCheckBox.isSelected()) {
            hobbies.add(readingCheckBox.getText());
        }
        if (browsingCheckBox.isSelected()) {
            hobbies.add(browsingCheckBox.getText());
        }
        if (sleepingCheckBox.isSelected()) {
            hobbies.add(sleepingCheckBox.getText());
        }
        if (travelingCheckBox.isSelected()) {
            hobbies.add(travelingCheckBox.getText());
        }

        int[] selectedIndices = sportList.getSelectedIndices();
        for (int index : selectedIndices) {
            sports.add(sportList.getModel().getElementAt(index));
        }

        player = new Player(name, nationality, dob, gender, playerType, hobbies, sports, year);
    }
}
