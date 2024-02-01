package deejamala.piyabud.lab7;

/* The class GuessNumberGameVer4 extends from the class deejamala.piyabud.lab5.GuessNumberGameVer3.
 * It has override method toString() to display the values of the min number to guess, 
 * the max number to guess, and the maximum number of tries.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class GuessNumberGameVer4 extends deejamala.piyabud.lab5.GuessNumberGameVer3 {
    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "GuessNumberGameVer4 (min:" + minNum + ", max:" + maxNum + ", max tries:" + maxTries + ")";
    }
}
