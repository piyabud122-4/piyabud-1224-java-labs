package deejamala.piyabud.lab3;

import java.util.*;

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
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

    static void playGames() {
        int attempts = 0;

        System.out.println("Welcome to a number guessing game!");
        
        while (attempts < maxTries) {
            System.out.print("Enter an integer between "+min+" and "+max+":");
            int guess = input.nextInt();
            attempts++;
            
            if (guess == answer) {
                if (attempts == 1) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried 1 time");
                } else if (attempts == maxTries) {
                    if (guess == answer) {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried "+attempts+" times");
                    } else {
                        System.out.println("You have tried "+maxTries+" times. You ran out of guesses");
                        System.out.println("The answer is "+answer); 
                    }
                } else {
                    System.out.println("Congratulations!");
                    System.out.println("You have tried "+attempts+" times");
                }
                
                System.out.println("Want to play again (Y or y):");
                String play = input.nextLine();
                if (play == "Y" || play == "y") {
                    continue;
                } else {
                    System.out.println("Thank you for playing our game. Bye!");
                    break;
                }
            } else if (guess > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        input.close();
  
    }

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}
