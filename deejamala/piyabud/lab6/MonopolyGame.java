package deejamala.piyabud.lab6;

/* The class MonopolyGame is inherited from Game.
 * It has one array of String named gamePieces to store players’ game pieces.
 * It has getter and setter method for gamePieces.
 * It has two constructors:
 * 1. MonopolyGame() accepts no parameter.It calls superclass’s constructor to initialize gameName to “Monopoly Game” and numOfPlayers to 4. 
 *    Also it initializes gamePieces to an array of {"car", "top hat", "thimble", "boot"}.
 * 2. MonopolyGame(String[]) accepts one array of String for gamePieces. It also initialize gameName to “Monopoly Game” and numOfPlayers to 4.
 * It overrides method playGame().
 * It overrides method toString() by using superclass's toString() to display the information of gameName and numOfPlayers.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Arrays;

public class MonopolyGame extends Game {
    String[] gamePieces;

    //getter setter
    public String[] getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    } 

    //constructors
    public MonopolyGame() { 
        super("Monoploy Game", 4);
        this.gamePieces = new String[] {"car", "top hat", "thimble", "boot"};
    }

    public MonopolyGame(String[] gamePieces) {
        super("Monoploy Game", 4);
        this.gamePieces = gamePieces;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }

    @Override
    public String toString() {
        return super.toString() + " { game pieces='" + Arrays.toString(gamePieces).replace("[","")
                .replace("]", "").replace(",", "") + " '}"; 
    }
} 
