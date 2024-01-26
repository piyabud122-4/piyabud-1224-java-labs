package deejamala.piyabud.lab7;

public class GuessNumberGameVer4 extends deejamala.piyabud.lab5.GuessNumberGameVer3 {
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + minNum + ", max:" + maxNum + ", max tries:" + maxTries + ")";
    }
}
