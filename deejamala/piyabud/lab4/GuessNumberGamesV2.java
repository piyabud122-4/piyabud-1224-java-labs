package deejamala.piyabud.lab4;

/**
 * The GuessNumberGamesV2 Program:
 * This program is an advanced iteration of NumberGuessingGames from Lab3, adding an array of integers to store the guesses 
 * and an integer variable to count the valid guesses.
 * Upon the game's conclusion, the player is provided with various options to review their guesses.
 * 'a' Option: Selecting this option displays a comprehensive list of all guesses made by the player throughout the game.
 * 'g' Option: This option allows the player to choose and view a specific guess.
 * Exit Feature: Any other keypress will exit the program.
 * After the player finishes reviewing their guesses, the game reverts to the standard gameplay as in NumberGuessingGames, 
 * allowing for a new round of play.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class GuessNumberGamesV2 {
    static int answer, min, max, maxTries;
    static int[] guesses;
    static Scanner input = new Scanner(System.in);

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        
        do {
            System.out.print("Enter the max value:");
            max = input.nextInt();
            if (max < min) {
                System.out.println("The max value must be at least equal to the min value");
            }
        } while (max < min);

        do {
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
            if (maxTries <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            } 
        } while (maxTries <= 0);

        guesses = new int[maxTries];
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        int numTries = 0;
        char review;
        int guess;
        boolean correct = false;

        do {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            guess = input.nextInt();

            do {
                if (guess < min || guess > max) {
                    System.out.print("Your guess should be in [" + min + "," + max + "]:");
                    guess = input.nextInt();
                }
            } while (guess < min || guess > max);
            
            guesses[numTries++] = guess;

            if (guess == answer) {
                correct = true;
                break;
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        } while (numTries < maxTries);

        if (correct) {
                System.out.println("Congratulations!");
        } else {
            System.out.println("You ran out of guesses. The answer was " + answer);
        }

        do {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            review = input.next().charAt(0);
            int count;

            switch (review) {
                case 'a':
                    System.out.println("All guesses:");
                    for (int i = 0; i < numTries; i++) {
                        System.out.print(guesses[i] + " ");    
                    }
                    System.out.println();
                    break;
                case 'g':
                    System.out.print("Enter the number of the guess you want to see (" + min + "-" + numTries +"): ");
                    count = input.nextInt();
                    System.out.println("Guess " + count + ":" + guesses[count-1]);
                    break;
                default:
                    break;
            }
        } while (review == 'a' || review == 'g');
    }

    static void playGames() {
        char play;
        
        do {
            genAnswer();
            playGame();
            System.out.print("Want to play again (Y or y):");
            play = input.next().charAt(0);
        } while (play == 'Y' || play == 'y');

        input.close();
    }

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}

