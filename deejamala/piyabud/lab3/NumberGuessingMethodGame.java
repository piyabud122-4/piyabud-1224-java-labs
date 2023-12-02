package deejamala.piyabud.lab3;

/*
 * The NumberGuessingMethodGame Program:
 * This program defines at least two subroutines, namely genAnswer() and playGame().
 * The program also contains a static int variable answer which contains the answer number of the game.
 * genAnswer() is a static void subroutine that will generate the answer 
 * and then store the value in the variable answer.
 * playGame() is a static void subroutine that runs the game.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.*;

public class NumberGuessingMethodGame {
    static int answer;
    final static int min = 1;
    final static int max = 20;

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        int attempts = 0;
        boolean correct = false;

        System.out.println("Welcome to a number guessing game!");
        Scanner input = new Scanner(System.in);
        
        while (attempts < 5) {
            System.out.print("Enter an integer between "+min+" and "+max+":");
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

    public static void main(String[] args) {
        genAnswer();
        playGame();
    }
}
