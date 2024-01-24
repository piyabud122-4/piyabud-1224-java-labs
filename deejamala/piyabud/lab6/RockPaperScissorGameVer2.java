package deejamala.piyabud.lab6;

/* The class RockPaperScissorGameVer2 is inherited from RockPaperScissorGame.
 * It overrides the methods toString() and playGame(). 
 * It also implements interface HasRule.
 * The interface HasRule has one void method called gameRule() to display.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {
    //constructors
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
