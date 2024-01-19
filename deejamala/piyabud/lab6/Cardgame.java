package deejamala.piyabud.lab6;

public abstract class Cardgame extends Game {
    int numOfCardsPerPlayer;

    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

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
