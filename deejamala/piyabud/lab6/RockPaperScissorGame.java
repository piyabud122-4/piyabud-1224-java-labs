package deejamala.piyabud.lab6;

/* The class RockPaperScissorGame is inherited from Game.
 * RockPaperScissorGame is a two players game.
 * It has two String variables, player1Choice and player2Choice.
 * It has has getter and setter methods for player1Choice and player2Choice.
 * It has two constructors.
 * 1. RockPaperScissorGame() accepts no argument.It calls the superclass constructor to set “Rock Paper Scissor Game” 
 *    for gameName and 2 for numOfPlayers. Set both player1Choice and player2Choice to “rock”.
 * 2. RockPaperScissorGame(String, String) accepts two String arguments to set the value of player1Choice and player2Choice.
 *    The constructor must set gameName to “Rock Paper Scissor Game” and numOfPlayers to 2 using superclass’s constructor.
 * It overrides method playGame().
 * It overrides method toString() by using superclass's toString() to display the information of gameName and numOfPlayers.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class RockPaperScissorGame extends Game {
    String player1Choice;
    String player2Choice;

    //getter setter
    public String getPlayer1Choice() {
        return player1Choice;
    }
    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }
    public String getPlayer2Choice() {
        return player2Choice;
    }
    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    //constructors
    public RockPaperScissorGame() {
        super("Rock Paper Scissor Game", 2);
        this.player1Choice = "rock";
        this.player2Choice = "rock";
    }

    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super("Rock Paper Scissor Game", 2);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissors Game");
    }

    @Override
    public String toString() {
        return super.toString() + " { player1Choice='" + player1Choice + "', player2Choice='" + player2Choice + "'}";
    }
}
