package deejamala.piyabud.lab3;

import java.util.*;

public class NumberGuessingMethodGame {
    static int answer;
    final static int MIN = 1;
    final static int MAX = 20;

    public static void main(String[] args) {
        genAnswer();
        playGame();
    }
}
