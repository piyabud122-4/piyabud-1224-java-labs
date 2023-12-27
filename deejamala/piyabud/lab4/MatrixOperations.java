package deejamala.piyabud.lab4;

/**
 * The MatrixOperations Program:
 * This program includes a menu for matrix creation and functionalities same as MatrixDisplayOptions.
 * After creating the matrix, present a menu with the operations and prompt the user to choose an operation.
 * Transpose Matrix: Create and display the transpose of the matrix.
 * Row and Column Sum: Calculate and display the sum of each row and each column.
 * Fing Max/Min Value: Find and display the minimum and maximum elements in the matrix.
 * Diagonal Display: Identify and display the elements on the main diagonal of the matrix.
 * The program repeatedly shows the matrix operations menu until the user chooses the “Exit” menu.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

import java.util.Scanner;

public class MatrixOperations {
    static int[][] matrix, transposedMatrix;
    static int rows, columns, choice, random;
    static Scanner input = new Scanner(System.in);

    static void displayMatrixCreationMenu() {
        do {
            System.out.println("Select matrix initialization method:");
            System.out.println("1. User Input");
            System.out.println("2. Random Matrix");
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

    static void displayMatrixOperationsMenu() {
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Transpose Matrix");
            System.out.println("2. Row and Column Sum");
            System.out.println("3. Find Max/Min Value");
            System.out.println("4. Diagonal Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    transposeMatrix();
                    break;
                case 2:
                    sumOfRowsAndColumns();
                    break;
                case 3:
                    findMinMaxValue();
                    break;
                case 4:
                    diagonalDisplay();
                    break;
                case 5:
                    displayMatrixCreationMenu();
                    break;
                default:
                    break;
            }
        } while (choice != 5);
        input.close();
    }

    static void transposeMatrix() {
        transposedMatrix = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void sumOfRowsAndColumns() {
        System.out.println("Row Sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < columns; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + (i + 1) + ": " + rowSum);
        }
        System.out.println("Column Sums:");
        for (int j = 0; j < columns; j++) {
            int columnSum = 0;
            for (int i = 0; i < rows; i++) {
                columnSum += matrix[i][j];
            }
            System.out.println("Column " + (j + 1) + ": " + columnSum);
        }
    }

    static void findMinMaxValue() {
        int minValue = matrix[0][0];
        int maxValue = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                }
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }
        System.out.println("Maximum Value: " + maxValue);
        System.out.println("Minimum Value: " + minValue);
        
    }

    static void diagonalDisplay() {
        System.out.println("Diagonal Elements:");
        for (int i = 0; i < Math.min(rows, columns); i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        displayMatrixCreationMenu();
        displayMatrixOperationsMenu();
    }
}
