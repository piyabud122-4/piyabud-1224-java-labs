package deejamala.piyabud.lab8;

/* The class PlayerFormV5 extends from PlayerFormV4.
 * This class add the icon images to the menu New, Open, and Save.
 * Use ImageIcon to create icon images.
 * And add the image at the bottom of the form just above the buttons.
 * implement the constructor ReadImage() to set the image for the form.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV5 extends PlayerFormV4 {
    protected JPanel bottomPanel;
    protected ImageIcon newIcon, openIcon, saveIcon;
    protected ReadImage imgPanel;

    public PlayerFormV5(String title) {
        super(title);
    }

    public void addMenus() {
        super.addMenus();
        newIcon = new ImageIcon("deejamala/piyabud/lab8/New-icon.png");
        openIcon = new ImageIcon("deejamala/piyabud/lab8/Open-icon.png");
        saveIcon = new ImageIcon("deejamala/piyabud/lab8/Save-icon.png");
        newMenu.setIcon(newIcon);
        openMenu.setIcon(openIcon);
        saveMenu.setIcon(saveIcon);
    }

    public void addComponents() {
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
