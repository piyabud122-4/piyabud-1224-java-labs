package deejamala.piyabud.lab3;

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
                System.err.println("The max value must be at least equal to the min value");
            }
        } while (max < min);

        do {
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
            if (maxTries <= 0) {
                System.err.println("The maximum number of tries must be greater than 0");
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
