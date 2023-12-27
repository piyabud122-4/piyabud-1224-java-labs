package deejamala.piyabud.lab2;

/*
 * The PrimitiveDataType Program:
 * This program generates output for eight variables based on StudentID and Firstname.
 * 
 * Author: Piyabud Deejamala
 * ID: 663040122-4
 * Sec: 2
 */

public class PrimitiveDataType {
    public static void main(String[] args) {
        String id = "663040122-4";
        String name = "Piyabud";
        System.out.println("Student ID : "+id);
        System.out.println("First Namr : "+name);
        int student_id = 630401224;

        byte mybyte = (byte) (student_id%100);
        short myshort = (short) (student_id%1000);
        int myint = student_id%1000000;
        long mylong = student_id%100000000;
        float myfloat = (float) (student_id%100) /100;
        double mydouble = (double) (student_id%10000000) /1000000;
        char mychar = name.charAt(0);
        boolean myboolean = (student_id%10) %2 != 0;

        System.out.println("Byte Value: "+mybyte);
        System.out.println("Short Value: "+myshort);
        System.out.println("Int Value: "+myint);
        System.out.println("Long Value: "+mylong);
        System.out.println("Float Value: "+myfloat);
        System.out.println("Double Value: "+mydouble);
        System.out.println("Char Value: "+mychar);
        System.out.println("Boolean Value: "+myboolean);
    }
}