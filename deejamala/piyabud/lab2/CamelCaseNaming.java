package deejamala.piyabud.lab2;

/*
 * The CamelCaseNaming Program:
 * This program accepts two arguments.
 * the first letter of the first word is capitalized, 
 * and the remaining letters are converted to lowercase. 
 * The same process is applied to the second word. 
 * Then, both words are concatenated.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class CamelCaseNaming {
    public static void main(String[] args) {
        if (args.length == 2) {
            String first_name = args[0];
            String second_name = args[1];
            String camelcasefirstname = first_name.substring(0,1).toUpperCase()+first_name.substring(1).toLowerCase();
            String camelcasesecondname = second_name.substring(0,1).toUpperCase()+second_name.substring(1).toLowerCase();
            System.out.println(camelcasefirstname+camelcasesecondname);
        } else {
            System.err.println("Error: Please provide exactly two arguments.");
        }
    }
}