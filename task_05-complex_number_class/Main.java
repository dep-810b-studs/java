package com.company;
 
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
 
        double re = 0;
        double im = 0;
 
        Scanner in = new Scanner(System.in);
 
        try
        {
            System.out.print("Please enter a real part of the firts complex naumber:");
            re = in.nextDouble();
            System.out.print("Please enter a imaginary part of the firts complex naumber:");
            im = in.nextDouble();
        }
        catch (InputMismatchException ex)
        {
            System.err.println("Error, you should enter a number");
            System.exit(1);
        }
 
        Complex ob1 = new Complex(re, im);
 
        try
        {
            System.out.print("Please enter a real part of the second complex number:");
            re = in.nextDouble();
            System.out.print("Please enter a imaginary part of the second complex number:");
            im = in.nextDouble();
        }
        catch (InputMismatchException ex)
        {
            System.err.println("Error, you should enter a number");
            System.exit(2);
        }
 
        Complex ob2 = new Complex(re, im);
 
        System.out.println(ob1 + " + " + ob2 + " = " + Complex.sum(ob1, ob2));
        System.out.println(ob1 + " * " + ob2 + " = " + Complex.multiply(ob1, ob2));
        try
        {
            System.out.println(ob1 + " / " + ob2 + " = " + Complex.division(ob1, ob2));
        }
        catch (IllegalArgumentException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(3);
        }
 
        System.out.println(ob1 + " ^ " + 3 + " = " + Complex.pow(ob1,3));
        System.out.println("sqrt(" + ob1 + ") = " +Complex.sqrt(ob1,3));
    }
}
