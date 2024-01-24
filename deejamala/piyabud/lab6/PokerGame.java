package deejamala.piyabud.lab6;

public class PokerGame extends Cardgame implements HasRule{
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
