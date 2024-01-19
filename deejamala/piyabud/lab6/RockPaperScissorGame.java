package deejamala.piyabud.lab6;

public class RockPaperScissorGame extends Game {
    String player1Choice;
    String player2Choice;

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
