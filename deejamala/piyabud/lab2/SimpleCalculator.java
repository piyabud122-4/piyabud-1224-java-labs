package deejamala.piyabud.lab2;

/*
 * The SimpleCalculator Program:
 * This program accepts three arguments
 * the first two arguments must be integer numbers
 * and the third arguments is the operator.
 * The program computes the result based on the specified operator.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length == 3) {
            int first_num = Integer.parseInt(args[0]);
            int second_num = Integer.parseInt(args[1]);
            String operator = args[2];
            if (operator.equals("+")) {
                System.out.println(first_num + "+" + second_num + "=" + (first_num+second_num));
            } else if (operator.equals("-")) {
                System.out.println(first_num + "-" + second_num + "=" + (first_num-second_num));
            } else if (operator.equals("x")) {
                System.out.println(first_num + "x" + second_num + "=" + (first_num*second_num));
            } else if (operator.equals("/")) {
                if (second_num == 0) {
                    System.err.println("Error: Division by zero is not allowed.");
                } else {
                System.out.println(first_num + "/" + second_num + "=" + (first_num/second_num));
                }
            } else {
                System.err.println("Error: Invalid operator. Please use '+', '-', 'x', or '/'.");
            }
        } else {
            System.out.println("Error: Please provide exactly three arguments.");
        }
    }
}