package deejamala.piyabud.lab4;

/**
 * The MatrixDisplay Program:
 * Users define the number of rows and columns for the matrix.
 * The program ensures that the entered row and column numbers are greater than 0.
 * Enable the user to input the elements of the matrix, starting from the top-left corner to the bottom-right corner.
 * Show the complete matrix after all elements have been entered.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class MatrixDisplay {
    static int[][] matrix;
    static int rows, columns;
    static Scanner input = new Scanner(System.in);

    static void inputMatrix() {
        do {
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
            displayMatrix();
        } while (rows > 0 && columns > 0);
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
        inputMatrix();
    }
}
