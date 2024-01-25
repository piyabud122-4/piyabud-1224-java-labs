package deejamala.piyabud.lab7;

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {

    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        return Integer.compare(game1.getMaxTries(), game2.getMaxTries());
    }
}
