package deejamala.piyabud.lab4;

import java.util.Scanner;

public class GuessNumberGameV3 {
    static int answer, min, max, maxTries, numTries;
    static int totalGuesses = 0;
    static int totalWin = 0;
    static int totalGame = 0;
    static int highScore = Integer.MAX_VALUE;
    static boolean correct = false;
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
        char review;
        int guess;
        numTries = 0;

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
                totalWin++;
                totalGuesses += numTries;
                if (numTries < highScore) {
                    highScore = numTries;
                }
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
                    System.out.println("Game Log: Answer: " + answer + ", Guesses: " + numTries + ", Win: " + correct);
                    break;
            }
        } while (review == 'a' || review == 'g');
    }

    static void playGames() {
        char play;
        
        do {
            genAnswer();
            playGame();
            numTries = 0;
            System.out.print("Want to play again (Y or y):");
            play = input.next().charAt(0);
            totalGame++;
        } while (play == 'Y' || play == 'y');

        do {
            System.out.println("----- Game Statistics -----");
            System.out.println("Total game played: " + totalGame);
            System.out.println("Total wins: " + totalWin);
            if (totalWin == 0) {
                System.err.println("Win Ratio: 0.0%");
            } else {
                System.out.println("Win Ratio: " + (double)(totalWin/totalGame)*100 + "%");
            }
            System.out.println("Average guess per game: " + (double)totalGuesses/totalGame);
            do {
                if (totalGame == 1) {
                    if (correct == false) {
                        System.out.println("High Score (Least Guesses): N/A");
                        break;
                    } else {
                        System.out.println("High Score (Least Guesses): " + highScore);
                        break;
                    }
                } else {
                    System.out.println("High Score (Least Guesses): " + highScore);
                    break;
                }
            } while (totalGame > 0);
            break;
        } while (play != 'Y' || play != 'y');
        input.close();
    }

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }
}
