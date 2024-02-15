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
        this.diceNumber = diceNumber; // initialize dice number
        setPreferredSize(new Dimension(canvasWidth, canvasHeight)); // set size with width canvasWidth and height canvasHeight
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight); // initial  ize a square which is a background
        createCircles(); // call method createCircles to place dots on a rectangle
    }

    protected void createCircles() {
        // initialize different types of circles (circleCenter, circleTopRight, ...)
        circleCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2, startSquareY + squareHeight / 2 - circleHeight / 2, circleWidth, circleHeight);
        circleTopLeft = new Ellipse2D.Double(startSquareX + margin, startSquareY + margin, circleWidth, circleHeight);
        circleTopRight = new Ellipse2D.Double(startSquareX + squareWidth - margin - circleWidth, startSquareY + margin, circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double(startSquareX + margin, startSquareY + squareHeight - margin - circleHeight, circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double(startSquareX + squareWidth - margin - circleWidth, startSquareY + squareHeight - margin - circleHeight, circleWidth, circleHeight);
        circleTopCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2, startSquareY + margin, circleWidth, circleHeight);
        circleBottomCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2, startSquareY + squareHeight - margin - circleHeight, circleWidth, circleHeight);
    }

    protected void drawDiceNumber() {
        // depending on a dice number, place red dots properly on a rectangle
        g2d.setColor(Color.RED);
        switch (diceNumber) {
            case 1:
                g2d.fill(circleCenter);
                break;
            case 2:
                g2d.fill(circleTopLeft);
                g2d.fill(circleBottomRight);
                break;
            case 3:
                g2d.fill(circleTopLeft);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomRight);
                break;
            case 4:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;
            case 5:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;
            case 6:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                g2d.fill(circleTopCenter);
                g2d.fill(circleBottomCenter);
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call paintComponent of super class
        g2d = (Graphics2D) g; // cast graphics object to graphics2D object
        g2d.setColor(Color.WHITE); // set paint to white
        g2d.fill(square); // fill the square
        drawDiceNumber(); // call code to draw dice number
    }
}
