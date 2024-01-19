package deejamala.piyabud.lab6;

interface HasRule {
    public void gameRule();
}

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {
    public RockPaperScissorGameVer2() {
        super();
    }

    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }

    @Override
    public String toString() {
        return "Rock Paper Scissor Game Version 2 : " + super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Game Version 2");
    }

    @Override
    public void gameRule() {
        System.out.println("Rock Paper Scissor Rule: ...");
    }
}
