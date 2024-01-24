package deejamala.piyabud.lab6;

/* The class MonopolyGameVer2 is inherited from MonopolyGame.
 * It overrides the methods toString() and playGame(). 
 * It also implements interface HasRule, UseBoard and UseDice.
 * The interface HasRule has one void method called gameRule() to display.
 * The interface UseBoard has one void method called setUpBoard() to display.
 * The interface UseDice has one void method called rollDice() to display.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {
    //constructors
    public MonopolyGameVer2() {
        super();
    }

    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    @Override
    public void playGame() {
        System.out.println("Play Monopoly Game Version 2");
    }

    @Override
    public String toString() {
        return "Monopoly Game Version 2 : " + super.toString();
    }

    @Override
    public void gameRule() {
        System.out.println("Monopoly Rules: ...");
    }

    @Override
    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    @Override
    public void rollDice() {
        System.out.println("Roll 2 Dice for monopoly game");
    }
}
