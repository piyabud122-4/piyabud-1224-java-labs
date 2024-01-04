package deejamala.piyabud.lab5;

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGame = 0;
    Scanner input;

    public GuessNumberGameVer1() {
        this.minNum = 1;
        this.maxNum = 10;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        this.maxTries = 3;
        numOfGame++;
        this.input = new Scanner(System.in);
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public void playGame() {
        boolean correct = false;
        int numTries = 0;
        int guess;

        do {
            System.out.println("Welcome to a number guessing game!");
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = input.nextInt();
            numTries++;

            do {
                if (guess < minNum || guess > maxNum) {
                    System.out.print("Your guess should be in [" + minNum + "," + maxNum + "]:");
                    guess = input.nextInt();
                }
            } while (guess < minNum || guess > maxNum);

            if (guess == correctNum) {
                correct = true;
                break;
            } else if (guess > correctNum) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        } while (numTries < maxTries);

        if (correct) {
                System.out.println("Congratulations!");
        } else {
            System.out.println("You ran out of guesses. The answer was " + correctNum);
        }
    }

    public static int getNumOfGames() {
        return numOfGame;
    }
}
