package deejamala.piyabud.lab8;

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
