package deejamala.piyabud.lab3;

/*
 * The NumberGuessingGames Program:
 * This program enables the user to play the number guessing game 
 * in the ConfigurableNumberGuessingGame version multiple times 
 * until the user indicates a desire to stop playing.
 * It includes playGames() to call method playGame().
 * In this version, the program checks and detects the configuration settings that the user may enter, 
 * and it also verifies whether a number falls outside the minimum or maximum values. 
 * If it does, the program prompts the user to enter a number again without incrementing the number of tries.
 * After the game ends, the program gives an option to play again if the user enters “y” or “Y”. 
 * If the user enters other values, the program will quit and print the message 
 * “Thank you for playing our games. Bye!".
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.*;

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
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
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        int numTries = 0;
        int guess;
        boolean correct = false;

        System.out.println("Welcome to a number guessing game!");
        
        do {
            do {
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                guess = input.nextInt();

                if (guess < min || guess > max) {
                    System.out.println("The number must be between " + min + " and " + max);
                }
            } while (guess < min || guess > max);

            numTries++;

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
            if (numTries == 1) {
                System.out.println("Congratulations!");
                System.out.println("You have tried 1 time");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You have tried " + numTries + " times");
            } 
        } else {
            System.out.println("You have tried " + maxTries + " times. You ran out of guesses");
            System.out.println("The answer is " + answer);   
        }
    }

    static void playGames() {
        char play;
        
        do {
            genAnswer();
            playGame();
            System.out.print("Want to play again (Y or y):");
            play = input.next().charAt(0);
        } while (play == 'Y' || play == 'y');

        System.out.println("Thank you for playing our game. Bye!");

        input.close();
    }

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}
