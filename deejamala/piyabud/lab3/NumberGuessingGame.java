package deejamala.piyabud.lab3;

/*
 * The NumberGuessingGame Program:
 * This program simulates a guessing game in which a user guesses a number from 1 to 20. 
 * The answer is randomly generated, and the user enters a number via the console.
 * The game ends when the user guesses the answer correctly or the user guesses the number incorrectly five times.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1;
        int max = 20;
        int answer = min + (int) (Math.random() * ((max - min) + 1));
        int attempts = 0;
        boolean correct = false;

        System.out.println("Welcome to a number guessing game!");
        Scanner input = new Scanner(System.in);
        
        while (attempts < 5) {
            System.out.print("Enter an integer between 1 and 20:");
            int guess = input.nextInt();
            attempts++;

            if (guess==answer) {
                correct = true;
                break;
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        input.close();

        if (correct) {
            if (attempts == 1) {
                System.out.println("Congratulations!");
                System.out.println("You have tried 1 time");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You have tried "+attempts+" times");
            } 
        } else {
            System.out.println("You have tried 5 times. You ran out of guesses");
            System.out.println("The answer is "+answer);   
        } 
    }
}

