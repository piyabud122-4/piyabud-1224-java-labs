package deejamala.piyabud.lab2;

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