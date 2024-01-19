package deejamala.piyabud.lab6;

interface HasRule {
    public void gameRule();
}

interface UseBoard {
    public void setUpBoard();
}

interface UseDice {
    public void rollDice();
}

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {
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
