package deejamala.piyabud.lab4;

/**
 * The MatrixDisplayOptions Program:
 * This program presents a menu with the options to the user and prompts the user to choose an option.
 * User Input : Similar to version 1, allow the user to input each element.
 * Random Number: Fill the matrix with random numbers between 0 and 9.
 * All Zeros : Initialize all elements of the matrix to 0.
 * All Ones : Initialize all elements of the matrix to 1.
 * Diagonal Matrix: Create a square matrix with 0s, except for 1s on the diagonal.
 * After creating the matrix, display it in a formatted manner.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class MatrixDisplayOptions {
    static int[][] matrix;
    static int rows, columns, choice, random;
    static Scanner input = new Scanner(System.in);

    static void displayOptions() {
        do {
            System.out.println("Select matrix initialization method:");
            System.out.println("1. User Input");
            System.out.println("2. Random Number");
            System.out.println("3. All Zeros");
            System.out.println("4. All Ones");
            System.out.println("5. Diagonal Matrix");
            System.out.print("Enter choice (1-5): ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    userInput();
                    displayMatrix();
                    break;
                case 2:
                    randomNumber();
                    displayMatrix();
                    break;
                case 3:
                    allZeros();
                    displayMatrix();
                    break;
                case 4:
                    allOnes();
                    displayMatrix();
                    break;
                case 5:
                    diagonalMatrix();
                    displayMatrix();
                    break;
                default:
                    break;
            }
            break;
        } while (choice != 0);
        input.close();
    }

    static void userInput() {
        do {
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
            if (rows <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rows <= 0);

        do {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (columns <= 0);

        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + i + "][" + j + "]: ");
                matrix[i][j] = input.nextInt();
            }
        }
    }

    static void randomNumber() {
        do {
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
            if (rows <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rows <= 0);

        do {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (columns <= 0);

        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                random = 1 + (int) (Math.random() * ((9 - 1) + 1));
                matrix[i][j] = random;
            }
        }
    }

    static void allZeros() {
        do {
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
            if (rows <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rows <= 0);

        do {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (columns <= 0);

        matrix = new int[rows][columns];
    }

    static void allOnes() {
        do {
            System.out.print("Enter the number of rows: ");
            rows = input.nextInt();
            if (rows <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (rows <= 0);

        do {
            System.out.print("Enter the number of columns: ");
            columns = input.nextInt();
            if (columns <= 0) {
                System.err.println("Enter the number of columns: Both rows and columns must be greater than 0. Please try again.");
            }
        } while (columns <= 0);

        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 1;
            }
        }
    }

    static void diagonalMatrix() {
        do {
            System.out.print("Enter the number of rows and columns for diagonal matrix: ");
            rows = input.nextInt();
            columns = input.nextInt();
            if (rows <= 0 || columns <= 0 || rows != columns) {
                System.out.println("Both rows and columns must be greater than 0 and equal to each other. Please try again.");
            }
        } while (rows <= 0 || columns <= 0 || rows != columns);

        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void displayMatrix() {
        System.out.println("Displaying Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        displayOptions();
    }
}
