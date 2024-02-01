package deejamala.piyabud.lab7;

/* The class SortByMaxTries:
 * It can sort the objects of GuessNumberGameVer4 by comparing the values of max tries.  
 * The greater the max tries, the greater the object of GuessNumberGameVer4 is.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        return Integer.compare(game1.getMaxTries(), game2.getMaxTries());
    }
}
