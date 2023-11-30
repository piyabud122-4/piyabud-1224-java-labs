package deejamala.piyabud.lab3;

import java.util.*;

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}
