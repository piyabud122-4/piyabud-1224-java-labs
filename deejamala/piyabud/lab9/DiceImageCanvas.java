package deejamala.piyabud.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;

    public DiceImageCanvas(int diceNumber) {
        // initialize dice number

        // set size with width canvasWidth and height canvasHeight

        // initialize a square which is a background

        // call method createCircles to place dots on a rectangle

    }

    protected void createCircles() {
        // initialize different types of circles (circleCenter, circleTopRight, ...)

    }

    protected void drawDiceNumber() {
        // depending on a dice number, place red dots properly on a rectangle

    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent of super class

        // cast graphics object to graphics2D object

        // set paint to white and fill the quare

        // call code to draw dice number

    }
}
