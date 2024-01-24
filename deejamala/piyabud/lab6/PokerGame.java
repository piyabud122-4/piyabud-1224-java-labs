package deejamala.piyabud.lab6;

/* The class PokerGame is inherited from CardGame.
 * It implements the interface HasRule.
 * It has 2 constructors.
 * 1. PokerGame() accepts no argument. It must call the superclass’s constructor to initialize the value of numOfCardsPerPlayer to 5. 
 *    It should also set gameName to “Poker Game” and numOfPlayer to 4.
 * 2. PokerGame(int) accepts one int variable for numOfCardsPerPlayer which must be initialized by calling the superclass’s constructor. 
 *    It should also set gameName to “Poker Game” and numOfPlayer to 4.
 * It overrides the method toString().
 * It overrides the method playGame().
 * It overrides the methods gameRule().
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class PokerGame extends Cardgame implements HasRule{
    //constructors
    public PokerGame() {
        super(5);
        this.gameName = "Poker Game";
        this.numOfPlayers = 4;
    }

    public PokerGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        this.gameName = "Poker Game";
        this.numOfPlayers = 4;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
    }

    @Override
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
}
