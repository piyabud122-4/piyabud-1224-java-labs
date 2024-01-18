package deejamala.piyabud.lab6;

public class MonopolyGame extends Game {
    String[] gamePieces;

    public String[] getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    } 

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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < gamePieces.length; i++) {
            result.append(gamePieces[i]);
            if (i < gamePieces.length - 1) {
                result.append(" ");
            }
        }
        return super.toString() + " { game pieces='" + result + " '}"; 
    }
} 
