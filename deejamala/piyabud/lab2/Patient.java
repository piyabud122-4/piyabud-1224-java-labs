package deejamala.piyabud.lab2;

/*
 * The Patient Program:
 * This program accepts three arguments
 * and display patient information.
 * The output should be
 * Patient's Name: <patient_name>
 * Age: <patient_age>
 * Gender: <patient_gender>
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class Patient {
    public static void main(String[] args) {
    if (args.length == 3) {
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        String gender = args[2];
        System.out.println("Patient's Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
    } else {
        System.err.println("ERROR: Invalid number of arguments. Please provide exactly three arguments.");
    }
    }      
}