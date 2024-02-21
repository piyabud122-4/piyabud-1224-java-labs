package deejamala.piyabud.lab10;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
        StringBuffer sports = new StringBuffer();
        List<String> selectedSports = sportList.getSelectedValuesList();
        int numSelected = selectedSports.size();
        for (int i = 0; i < numSelected; i++) {
            sports.append(selectedSports.get(i) + " ");
        }
        JOptionPane.showMessageDialog(this, "Selected sports are " + sports.toString());
    }
}
