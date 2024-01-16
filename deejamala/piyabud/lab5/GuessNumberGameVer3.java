package deejamala.piyabud.lab5;

import java.util.Scanner;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    protected int guesses[];
    protected int numGuesses = 0;
    int MAX_GUESSES = 20;
    int numTries;
    Scanner input = new Scanner(System.in);

    public GuessNumberGameVer3() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    public void guessAverage() {
        System.out.println("Average = ");
    }

    public void guessMin() {
        System.out.println("Min = ");
    }

    public void guessMax() {
        System.out.println("Max = ");
    }

    public void playGames() {
        char choice;

        do {
            playGame();
            do {
                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
                System.out.println("Type 'v' to show the average of guesses, 'm' to show the minimum of guesses, or 'x' show the maximum of guesses");
                choice = input.next().charAt(0);

                if (choice == 'y' || choice == 'Y') {
                    playGame();
                } else if (choice == 'a' || choice == 'A') {
                    showGuesses();
                } else if (choice == 'g' || choice == 'G') {
                    showSpecific();
                } else if (choice == 'q' || choice == 'Q') {
                    break;
                } else if (choice == 'v' || choice == 'V') {
                    guessAverage();
                } else if (choice == 'm' || choice == 'M') {
                    guessMin();
                } else if (choice == 'x' || choice == 'X') {
                    guessMax();
                } else {
                    System.out.println("Invalid command");
                }
            } while (choice != 'q');
        } while (choice == 'y');
    }
}
