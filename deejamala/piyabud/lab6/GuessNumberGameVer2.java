package deejamala.piyabud.lab6;

/* The class GuessNumberGameVer2 is inherited from GuessNumberGameVer1.
 * It overrides the methods toString() and playGame(). 
 * It also implements interface HasRule.
 * The interface HasRule has one void method called gameRule() to display.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {
    //constructors
    public GuessNumberGameVer2() {
        super();
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Version 2");
    }

    @Override
    public String toString() {
        return "Guess Number Game Version 2 : " + super.toString();
    }

    @Override
    public void gameRule() {
        System.out.println("Guess Number Game Rules : ...");
    }
}
