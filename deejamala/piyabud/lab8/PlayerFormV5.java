package deejamala.piyabud.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV5 extends PlayerFormV4 {
    protected JPanel bottomPanel;
    protected ImageIcon newIcon, openIcon, saveIcon;
    protected ReadImage imgPanel;

    public PlayerFormV5(String title) {
        super(title);
    }

    protected void addMenus() {
        super.addMenus();
        newIcon = new ImageIcon(this.getClass().getResource("New-icon.png"));
        openIcon = new ImageIcon(this.getClass().getResource("Open-icon.png"));
        saveIcon = new ImageIcon(this.getClass().getResource("Save-icon.png"));
        newMenu.setIcon(newIcon);
        openMenu.setIcon(openIcon);
        saveMenu.setIcon(saveIcon);
    }

    protected void addComponents() {
        super.addComponents();
        imgPanel = new ReadImage();
        imgPanel.setPreferredSize(new Dimension(400, 225));

        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(imgPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
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
