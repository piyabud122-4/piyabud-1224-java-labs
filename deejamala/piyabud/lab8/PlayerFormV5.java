package deejamala.piyabud.lab8;

import javax.swing.SwingUtilities;

public class PlayerFormV5 extends PlayerFormV4 {
    public PlayerFormV5(String title) {
        super(title);
    }

    protected void addComponents() {
        super.addComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }
}
