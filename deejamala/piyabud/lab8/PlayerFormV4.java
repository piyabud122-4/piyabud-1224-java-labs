package deejamala.piyabud.lab8;

/* The class PlayerFormV4 extends from PlayerFormV3.
 * This class add the checkboxes for hobbies.
 * Hobbies has four checkboxes for "Reading", "Browsing", "Sleeping", and "Traveling".
 * The Sleeping box is checked by default.
 * Add the the list of favorite sports.
 * This list includes four sports for "Badminton", "Boxing", "Football", and "Running".
 * The "Football" is checked by default.
 * And add the slider for the number of years in this sport.
 *  
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {    
    protected JPanel checkboxPanel, hobbiesPanel, sportPanel, yearOfExperiencePanel, notePanel;
    protected JLabel hobbiesLabel, sportLabel, yearOfExperienceLabel;
    protected JCheckBox hobbiesCheckBox, readingCheckBox, browsingCheckBox, sleepingCheckBox, travelingCheckBox;
    protected JList<String> sportList;
    protected JSlider yearOfExperienceSlider;

    public PlayerFormV4(String title) {
        super(title);
    }

    protected void addComponents() {
        super.addComponents();
        hobbiesLabel = new JLabel("Hobbies: ");
        readingCheckBox = new JCheckBox("Reading");
        browsingCheckBox = new JCheckBox("Browsing");
        sleepingCheckBox = new JCheckBox("Sleeping", true);
        travelingCheckBox = new JCheckBox("Traveling");
        checkboxPanel = new JPanel();
        checkboxPanel.add(readingCheckBox);
        checkboxPanel.add(browsingCheckBox);
        checkboxPanel.add(sleepingCheckBox);
        checkboxPanel.add(travelingCheckBox);
        hobbiesPanel = new JPanel(new BorderLayout());
        hobbiesPanel.add(hobbiesLabel, BorderLayout.NORTH);
        hobbiesPanel.add(checkboxPanel);

        sportLabel = new JLabel("Sport: ");
        String[] sport = {"Badminton", "Boxing", "Football", "Running"};
        sportList = new JList<>(sport);
        sportList.setSelectedIndex(2);
        sportPanel = new JPanel(new GridLayout(1, 2));
        sportPanel.add(sportLabel);
        sportPanel.add(sportList);

        yearOfExperienceLabel = new JLabel("Year of experience in this sport: ");
        yearOfExperienceSlider = new JSlider(0,20,0);
        yearOfExperienceSlider.setPaintTrack(true);
        yearOfExperienceSlider.setPaintTicks(true);
        yearOfExperienceSlider.setPaintLabels(true);
        yearOfExperienceSlider.setMajorTickSpacing(5);
        yearOfExperienceSlider.setMinorTickSpacing(1);
        yearOfExperiencePanel = new JPanel(new BorderLayout());
        yearOfExperiencePanel.add(yearOfExperienceLabel, BorderLayout.NORTH);
        yearOfExperiencePanel.add(yearOfExperienceSlider);

        middlePanel.removeAll();
        notePanel = new JPanel(new BorderLayout());
        notePanel.add(noteLabel, BorderLayout.NORTH);
        notePanel.add(scrollPane);

        middlePanel.setLayout(new GridLayout(4, 2));
        middlePanel.add(hobbiesPanel);
        middlePanel.add(sportPanel);
        middlePanel.add(yearOfExperiencePanel);
        middlePanel.add(notePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }
}
