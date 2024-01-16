package deejamala.piyabud.lab5;

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input = new Scanner(System.in);

    public GuessNumberGameVer1() {
        minNum = 1;
        maxNum = 10;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum ,int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
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
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));

        System.out.println("Welcome to a number guessing game!");

        do {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            guess = input.nextInt();
            numTries++;

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

    public static int getNumOfGames() {
        return numOfGames;
    }

    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum + " max number of tries as " + maxTries;
    }
}
