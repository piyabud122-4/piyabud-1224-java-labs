package deejamala.piyabud.lab6;

/* The class Game is an abstract class.
 * It has a String variable named gameName and an int variable named numOfPlayers.
 * It has getter and setter methods for gameName and numOfPlayers.
 * It has two constructors.
 * 1. One accepts no argument. It initiates gameName to “unknown game” and numOfPlayers to 0.
 * 2. The other one accepts two arguments: String and int. The string is for initializing the gameName and the int is for numOfPlayers.
 * It overrides toString() method that output the gameName and numOfPlayers.
 * It has an abstract method called playGame().
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public abstract class Game {
    String gameName;
    int numOfPlayers;

    //getter setter
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
