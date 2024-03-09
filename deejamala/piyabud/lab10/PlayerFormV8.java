package deejamala.piyabud.lab10;

/* The class PlayerFormV8 extends from PlayerFormV7 and implements ListSelectionListener.
 * Overrides the method addListeners() such that the appropriate listener is added to the list.
 * Implement the method valueChanged() that will handle when items in a list are selected.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import deejamala.piyabud.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    public PlayerFormV8(String title) {
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
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener();
        sportList.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        boolean isAdjusting = e.getValueIsAdjusting();
        StringBuffer sports = new StringBuffer();
        if (!isAdjusting) {
            List<String> selectedSports = sportList.getSelectedValuesList();
            int numSelected = selectedSports.size();
            for (int i = 0; i < numSelected; i++) {
                sports.append(selectedSports.get(i) + " ");
            }
            if (!sportList.isSelectionEmpty()) { // add function check sportlist
                JOptionPane.showMessageDialog(this, "Selected sports are " + sports.toString());
            }
        }
    }
}
