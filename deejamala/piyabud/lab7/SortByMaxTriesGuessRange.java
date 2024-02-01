package deejamala.piyabud.lab7;

/* The class SortByMaxTriesGuessRange:
 * Consider the value of the max number of tries. The greater the max number of tries, the larger the object. 
 * However, if the number of max tries is the same, we want to compare the random guess range. 
 * The smaller the random range, the larger the object.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Comparator;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        int compareMaxTries = Integer.compare(game1.getMaxTries(), game2.getMaxTries());

        if (compareMaxTries == 0) {
            int range1 = game1.getMaxNum() - game1.getMinNum();
            int range2 = game2.getMaxNum() - game2.getMinNum();
            return Integer.compare(range2, range1);
        } else {
            return compareMaxTries;
        }
    }
}
