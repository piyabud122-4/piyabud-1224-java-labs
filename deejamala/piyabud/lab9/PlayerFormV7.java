package deejamala.piyabud.lab9;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
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

    public void addListener() {
        maleRadioButton.addItemListener(this);
        femaleRadioButton.addItemListener(this);
        readingCheckBox.addActionListener(this);
        browsingCheckBox.addActionListener(this);
        sleepingCheckBox.addActionListener(this);
        travelingCheckBox.addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton srcRadioButton = (JRadioButton) e.getItemSelectable();
        String genderRadioButton = srcRadioButton.getActionCommand();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(this, "Gender is updated to " + genderRadioButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == readingCheckBox || src == browsingCheckBox || src == sleepingCheckBox || src == travelingCheckBox) {
            JCheckBox checkBox = (JCheckBox) src;
            String hobby = checkBox.getText();
            if (checkBox.isSelected()) {
                JOptionPane.showMessageDialog(this, hobby + " is one of the hobbies");
            } else {
                JOptionPane.showMessageDialog(this, hobby + " is no longer one of the hobbies");
            }
        }
    }
}
