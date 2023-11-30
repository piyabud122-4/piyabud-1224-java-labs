package deejamala.piyabud.lab3;

import java.util.*;

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in); 

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }
}
