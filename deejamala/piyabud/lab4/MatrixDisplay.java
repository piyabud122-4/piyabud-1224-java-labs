package deejamala.piyabud.lab4;

import java.util.Scanner;

public class MatrixDisplay {
    static int[][] matrix;
    static int rows, columns;
    static Scanner input = new Scanner(System.in);

    static void inputMatrix() {
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
        input.close();
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
        displayMatrix();
    }
}
