package deejamala.piyabud.lab6;

/* The class DungeonsAndDragonsGame is inherited from CardGame.
 * It implements interface HasRule, UseBoard, and UseDice.
 * It has two constructors :
 * 1. DungeonsAndDragonsGame() accepts no argument.
 *    which must be initialized by calling the superclass’s constructor.
 *    It should also set gameName to “Dungeons And Dragons Game” and numOfPlayer to 3.
 * 2. DungeonsAndDragonsGame(int) accepts one int variable for numOfCardsPerPlayer 
 *    which must be initialized by calling the superclass’s constructor.
 *    It should also set gameName to “Dungeons And Dragons Game” and numOfPlayer to 3.
 * It overrides the method toString().
 * It overrides method playGame().
 * It overrides the methods from interface, gameRule(), setUpBoard(), and rollDice().
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class DungeonsAndDragonsGame extends Cardgame implements HasRule, UseBoard, UseDice {
    //constructors
    public DungeonsAndDragonsGame() {
        super(6);
        this.gameName = "Dungeons And Dragons Game";
        this.numOfPlayers = 3;
    } 

    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        this.gameName = "Dungeons And Dragons Game";
        this.numOfPlayers = 3;
    }

    @Override
    public String toString() {
        return "Dungeons And Dragons Game : " + super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Dungeons And Dragons Game");
    }

    @Override
    public void gameRule() {
        System.out.println("Dungeons And Dragons Game Rules : ...");
    }

    @Override
    public void setUpBoard() {
        System.out.println("Setting up board for Dungeons And Dragons Game");
    }

    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }
}
