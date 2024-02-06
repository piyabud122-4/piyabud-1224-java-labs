package deejamala.piyabud.lab8;

/* The class ReadImage extemds from JPanel.
 * Override the paintComponent() to draw an image on the form.
 * This class has the constructor ReadImage() to read an image.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ReadImage extends JPanel {
    BufferedImage img;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public ReadImage() {
        try {
            img = ImageIO.read(getClass().getResource("./Football.jpg"));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
