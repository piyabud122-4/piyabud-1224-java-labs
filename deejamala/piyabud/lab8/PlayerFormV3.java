package deejamala.piyabud.lab8;

/* The class PlayerFormV3 extends from PlayerFormV2 in lab7.
 * This class implement addMenus() to add the menu bar with these two following menus.
 * - Menu "File" has four menu items which are "New", "Open", "Save" , and "Exit".
 * - Menu "Config" has two menu items which are "Color", and "Size".
 * And call method addMenus() in createAndShowGUI() to add all components in the menu.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import deejamala.piyabud.lab7.PlayerFormV2;
import javax.swing.*;

public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorMenu, sizeMenu;
    protected JMenuItem newMenu, openMenu, saveMenu, exitMenu, redMenu, greenMenu, blueMenu, sixteenMenu, twentyMenu, twentyfourMenu;

    public PlayerFormV3(String title) {
        super(title);
    }

    protected void addMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMenu = new JMenuItem("New");
        openMenu = new JMenuItem("Open");
        saveMenu = new JMenuItem("Save");
        exitMenu = new JMenuItem("Exit");
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        redMenu = new JMenuItem("Red");
        greenMenu = new JMenuItem("Green");
        blueMenu = new JMenuItem("Blue");
        sizeMenu = new JMenu("Size");
        sixteenMenu = new JMenuItem("16");
        twentyMenu = new JMenuItem("20");
        twentyfourMenu = new JMenuItem("24");

        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);
        colorMenu.add(redMenu);
        colorMenu.add(greenMenu);
        colorMenu.add(blueMenu);
        sizeMenu.add(sixteenMenu);
        sizeMenu.add(twentyMenu);
        sizeMenu.add(twentyfourMenu);
        configMenu.add(colorMenu);
        configMenu.add(sizeMenu);

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }
}
