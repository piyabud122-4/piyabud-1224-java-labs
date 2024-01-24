package deejamala.piyabud.lab6;

/* The class GuessNumberGameVer1 is is inherited from Game.
 * It has variables minNum, maxNum, correctNum, maxTries.
 * It has getter and setter methods for minNum, maxNum, maxTries.
 * It has three constructors GuessNumberGameVer1(), GuessNumberGameVer1(int, int) and GuessNumberGameVer1(int, int, int).
 * All the constructors should set gameName to “Guess Number Game” and numOfPlayers to 1 by using superclass's constructor.
 * It overrides method toString() by using superclass's toString() to display the information of gameName and numOfPlayers.
 * It overrides method playGame().
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class GuessNumberGameVer1 extends Game {
    int minNum, maxNum, correctNum, maxTries;

    //getter setter
    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }
    
    //constructors
    public GuessNumberGameVer1() {
        super("Guess Number Game", 1);
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    @Override
    public String toString() {
        return super.toString() + " { minNum='" + minNum + "', maxNum='" + maxNum + "', correctNum='" + correctNum + "', maxTries='" + maxTries + "'}";
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game");
    }
}
