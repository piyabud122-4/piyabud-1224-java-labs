package deejamala.piyabud.lab10;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customMenu;

    public PlayerFormV11(String title) {
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
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
        msw.addComponents();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addMenus() {
        super.addMenus();
        customMenu = new JMenuItem("Custom");
        colorMenu.add(customMenu);
    }

    @Override
    public void addListener() {
        super.addListener();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
    }
}
