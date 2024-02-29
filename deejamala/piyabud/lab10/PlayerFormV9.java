package deejamala.piyabud.lab10;

/* The class PlayerFormV9 extends from PlayerFormV8 implements ChangeListener.
 * Overrides the method addListeners() such that the appropriate listener is added to the JSllider 
 * previously defined in PlayerFormV4 in Lab8.
 * Implement the method stateChanged() that will handle when the marker of the slider is moved.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {
    public PlayerFormV9(String title) {
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
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener();
        yearOfExperienceSlider.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            double year = source.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + year);
        }
    }
}
