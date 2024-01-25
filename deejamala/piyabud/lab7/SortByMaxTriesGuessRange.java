package deejamala.piyabud.lab7;

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
