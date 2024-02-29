package deejamala.piyabud.lab9;

/* The class PlayerFormV7 extends from PlayerFormV6 and implements ItemListener.
 * When the user clicks at a radio button, 
 * the program displays the message dialog showing the update in the format “Gender is updated to <selected gender>”.
 * When the user selects a checkbox, the program displays the dialog “<hobby> is one of the hobbies”.
 * When the user deselects a checkbox, the program displays the dialog “<hobby> is no longer one of the hobbies”.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {
    public PlayerFormV7(String title) {
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
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener(); //add super method
        maleRadioButton.addItemListener(this);
        femaleRadioButton.addItemListener(this);
        readingCheckBox.addItemListener(this);
        browsingCheckBox.addItemListener(this);
        sleepingCheckBox.addItemListener(this);
        travelingCheckBox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        SwingUtilities.invokeLater(new Runnable() { //add the solving JCheckBox
            public void run() {
                Object item = e.getItemSelectable();
                if (item instanceof JRadioButton) {
                    JRadioButton srcRadioButton = (JRadioButton) e.getItemSelectable();
                    String genderRadioButton = srcRadioButton.getActionCommand();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        JOptionPane.showMessageDialog(PlayerFormV7.this, "Gender is updated to " + genderRadioButton);
                    }
                } else if (item instanceof JCheckBox) { //add the JCheckBox in itemStateChanged
                    JCheckBox srcCheckBox = (JCheckBox) e.getItemSelectable();
                    String hobbiesCheckBox = srcCheckBox.getActionCommand();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        JOptionPane.showMessageDialog(PlayerFormV7.this, hobbiesCheckBox + "is one of the hobbies");           
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        JOptionPane.showMessageDialog(PlayerFormV7.this, hobbiesCheckBox + " is no longer one of the hobbies");
                    }
                }
            }
        });
    }
}
