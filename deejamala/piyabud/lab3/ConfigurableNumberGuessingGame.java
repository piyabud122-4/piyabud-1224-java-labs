package deejamala.piyabud.lab3;

import java.util.*;

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in); 
    
    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        int numTries = 0;
        boolean correct = false;

        System.out.println("Welcome to a number guessing game!");
        Scanner input = new Scanner(System.in);
        
        while (numTries < maxTries) {
            System.out.print("Enter an integer between "+min+" and "+max+":");
            int guess = input.nextInt();
            numTries++;
            
            if (guess == answer) {
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
            if (numTries == 1) {
                System.out.println("Congratulations!");
                System.out.println("You have tried 1 time");
            } else {
                System.out.println("Congratulations!");
                System.out.println("You have tried "+numTries+" times");
            } 
        } else {
            System.out.println("You have tried "+maxTries+" times. You ran out of guesses");
            System.out.println("The answer is "+answer);   
        }
    }

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }
}
