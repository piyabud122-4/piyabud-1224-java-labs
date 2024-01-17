package deejamala.piyabud.lab5;

/**
 * The GuessNumberGameVer3 Program:
 * GuessNumberGameVer3 inherited from GuessNumberGameVer2.
 * This program has three new methods, which are: 
 * guessAverage() to calculate the average.
 * guessMin() to calculate minimum of the guesses respectively.
 * guessMax() to calculate maximum of the guesses respectively.
 * If the user types in ‘v’ or ‘V’, the program should call method guessAverage() to display the average value of all the guesses.
 * If the user types in ‘m’ or ‘M’, the program should call the method guessMin() to show the minimum of the guesses the user entered.
 * If the user types in ‘x’ or ‘X’, the program should call the method guessMax() to display the maximum of all the guesses.
 * When the user types in an incorrect command, the program displays the message “Invalid command” repeats the question.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

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

    public void guessAverage() {
        if (numTries == 0) {
            System.out.println("Average = 0.00");
        }
        int sum = 0;
        for (int i = 0; i < numTries; i++) {
            sum += guesses[i];
        }
        System.out.println("Average = " + (double) sum / numTries);
    }
    
    public void guessMin() {
        if (numTries == 0) {
            System.out.println("Min = 0"); 
        }
        int min = guesses[0];
        for (int i = 1; i < numTries; i++) {
            if (guesses[i] < min) {
                min = guesses[i];
            }
        }
        System.out.println("Min = " + min);
    }
    
    public void guessMax() {
        if (numTries == 0) {
            System.out.println("Max = 0");
        }
        int max = guesses[0];
        for (int i = 1; i < numTries; i++) {
            if (guesses[i] > max) {
                max = guesses[i];
            }
        }
        System.out.println("Max = " + max);
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
