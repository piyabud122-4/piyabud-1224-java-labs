package deejamala.piyabud.lab5;

/**
 * The GuessNumberGameVer3 Program:
 * GuessNumberGameVer3 inherited from GuessNumberGameVer2.
 * This program has three new methods, which are: 
 * guessAverage() to calculate the average.
 * guessMin() to calculate minimum of the guesses respectively.
 * guessMax() to calculate maximum of the guesses respectively.
 * If the user types in ‘v’ or ‘V’, the program should call method guessAverage() to display the average value of all the guesses.
 * If the user types in ‘m’ or ‘M’, the program should call the method guessMin() to show the minimum of the guesses the user entered.
 * If the user types in ‘x’ or ‘X’, the program should call the method guessMax() to display the maximum of all the guesses.
 * When the user types in an incorrect command, the program displays the message “Invalid command” repeats the question.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {
    public GuessNumberGameVer3() {
        super();
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    public void guessAverage() {
        if (numTries == 0) {
            System.out.println("Average = 0.00");
        }
        int sum = 0;
        for (int i = 0; i < numTries; i++) {
            sum += guesses[i];
        }
        System.out.println("Average = " + (double) sum / numTries);
    }
    
    public void guessMin() {
        if (numTries == 0) {
            System.out.println("Min = 0"); 
        }
        int min = guesses[0];
        for (int i = 1; i < numTries; i++) {
            if (guesses[i] < min) {
                min = guesses[i];
            }
        }
        System.out.println("Min = " + min);
    }
    
    public void guessMax() {
        if (numTries == 0) {
            System.out.println("Max = 0");
        }
        int max = guesses[0];
        for (int i = 1; i < numTries; i++) {
            if (guesses[i] > max) {
                max = guesses[i];
            }
        }
        System.out.println("Max = " + max);
    }

    public void playGames() {
        char choice;

        do {
            playGame();
            do {
                System.out.println("If want to play again? type 'y' to continue or 'q' to quit:");
                System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
                System.out.println("Type 'v' to show the average of guesses, 'm' to show the minimum of guesses, or 'x' show the maximum of guesses");
                choice = input.next().charAt(0);

                if (choice == 'y' || choice == 'Y') {
                    playGame();
                } else if (choice == 'a' || choice == 'A') {
                    showGuesses();
                } else if (choice == 'g' || choice == 'G') {
                    showSpecific();
                } else if (choice == 'q' || choice == 'Q') {
                    break;
                } else if (choice == 'v' || choice == 'V') {
                    guessAverage();
                } else if (choice == 'm' || choice == 'M') {
                    guessMin();
                } else if (choice == 'x' || choice == 'X') {
                    guessMax();
                } else {
                    System.out.println("Invalid command");
                }
            } while (choice != 'q');
        } while (choice == 'y');
    }
}
