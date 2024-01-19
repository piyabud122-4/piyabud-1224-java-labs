package deejamala.piyabud.lab6;

import java.util.Arrays;

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
        return super.toString() + " { game pieces='" + Arrays.toString(gamePieces).replace("[","")
                .replace("]", "").replace(",", "") + " '}"; 
    }
} 
