package deejamala.piyabud.lab5;

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
