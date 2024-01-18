package deejamala.piyabud.lab6;

public abstract class Game {
    String gameName;
    int numOfPlayers;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public Game() {
        this.gameName = "unknown game";
        this.numOfPlayers = 0;
    }

    public Game(String gameName, int numOfPlayers) {
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
    }   

    @Override
    public String toString() {
        return "{ gameName='" + gameName + "', numOfPlayers='" + numOfPlayers + "'}";
    }

    public abstract void playGame();
}
