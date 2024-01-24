package deejamala.piyabud.lab6;

/* The class Cardgame is an abstract class.
 * It has one int variable called numOfCardsPerPlayer that keeps the number of cards each player gets in a game.
 * It has a getter and setter for numOfCardsPerPlayer.
 * It has two constructors :
 * 1. CardGame() accepts no argument. Use the superclass’s constructor to initialize. It also set the value of numOfCardsPerPlayer to 0.
 * 2. CardGame(int) accepts one int variable that is for numOfCardsPerPlayer. It must call the superclass’s constructor.
 * It overrides the method toString(). Display the numOfCardsPerPlayer. 
 * It contains an abstract method playGame().
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public abstract class Cardgame extends Game {
    int numOfCardsPerPlayer;

    //constructors
    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    //getter setter
    public Cardgame() {
        super();
        this.numOfCardsPerPlayer = 0;
    }

    public Cardgame(int numOfCardsPerPlayer) {
        super();
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    @Override
    public String toString() {
        return super.toString() + " {numOfCardPerPlayer='" + numOfCardsPerPlayer + "'}"; 
    }

    public abstract void playGame();
}
