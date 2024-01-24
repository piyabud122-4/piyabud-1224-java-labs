package deejamala.piyabud.lab6;

public class DungeonsAndDragonsGame extends Cardgame implements HasRule, UseBoard, UseDice {
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
