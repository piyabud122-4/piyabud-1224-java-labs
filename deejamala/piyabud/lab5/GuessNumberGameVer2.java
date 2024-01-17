package deejamala.piyabud.lab5;

/**
 * The GuessNumberGameVer2 Program:
 * GuessNumberGameVer2 inherited from GuessNumberGameVer1.
 * Three constructors of GuessNumberGameVer2 that call the constructors of the superclass (GuessNumberGameVer1).
 * In these constructors, you also need to use a new operator to allocate memory space for the array guesses 
 * by assuming that there can be at most 20 guesses.
 * Using the annotation @Override to override the method playGame() so that if the guess number is not in the range, 
 * numGuesses won’t be incremented and the guess number won’t be added into the array of integers, guesses.
 * This program has three new methods which are: 
 * showSpecific() - This method will display the guess number at a specific position 
 *                  after the user types ‘g’ or ‘G’ and then the specific position.
 * showGuesses() - This method will list all the user’s guesses after the game ends and the user types ‘a’ or ‘A’.
 * playGames() - This method will call other methods: playGame(), showSpecific(), and showGuesses() 
 *               and keep running until the user types ‘q’.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected int guesses[];
    protected int numGuesses = 0;
    int MAX_GUESSES = 20;
    int numTries;
    Scanner input = new Scanner(System.in);

    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    @Override
    public void playGame() {
        boolean correct = false;
        int guess;
        numTries = 0;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        System.out.println("Welcome to a number guessing game!");

        do {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = input.nextInt();

            if (invalidGuess(guess)) {
                guesses[numTries++] = guess;

                if (guess == correctNum) {
                    correct = true;
                    break;
                } else if (guess > correctNum) {
                    System.out.println("Try a lower number!");
                } else {
                    System.out.println("Try a higher number!");
                }
            } else {
                System.err.println("Your guess should be in [" + minNum + "," + maxNum + "]:");
            }
        } while (numTries < maxTries);

        if (correct) {
                System.out.println("Congratulations!");
                if (numTries == 1) {
                    System.out.println("You have tried " + numTries + " time");
                } else {
                    System.out.println("You have tried " + numTries + " times");
                }
        } else {
            System.out.println("You have tried " + numTries + " times. You ran out of guesses.");
            System.out.println("The answer was " + correctNum);
        }
    }

    public boolean invalidGuess(int guess) {
        return guess >= minNum && guess <= maxNum;
    }

    public void showSpecific() {
        int count;
        System.out.println("Enter which guess in the range (" + 1 + "-" + numTries +")");
        count = input.nextInt();
        System.out.println("Guess number " + count + " is " + guesses[count-1]);
    }

    public void showGuesses() {
        for (int i = 0; i < numTries; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    public void playGames() {
        char choice;

        do {
            playGame();
            do {
                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
                choice = input.next().charAt(0);
                if (choice == 'y' || choice == 'Y') {
                    playGame();
                } else if (choice == 'a' || choice == 'A') {
                    showGuesses();
                } else if (choice == 'g' || choice == 'G') {
                    showSpecific();
                } else if (choice == 'q' || choice == 'Q') {
                    break;
                } else {
                    break;
                }
            } while (choice != 'q');
        } while (choice == 'y');
    }
}
