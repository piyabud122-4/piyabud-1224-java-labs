package deejamala.piyabud.lab6;

interface HasRule {
    public void gameRule();
}

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {
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
