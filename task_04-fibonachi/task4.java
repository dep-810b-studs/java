package com.company;
 
 
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main
{
 
    public static void main(String[] args)
    {
 
        int num = 0;
 
        Scanner in = new Scanner(System.in);
 
        System.out.print("Please, enter a number for factorial: ");
 
        try
        {
           num = in.nextInt();
        }
        catch (InputMismatchException ex)
        {
            System.err.println("Error, you should enter a digit");
            System.exit(1);
 
        }
 
        try
        {
          System.out.println("factorial("+ num +") = " +factorial(BigInteger.valueOf(num)));
        }
        catch (IllegalArgumentException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(2);
        }
 
        System.out.print("Please, enter a number for fibonachi: ");
 
        try
        {
            num = in.nextInt();
        }
        catch (InputMismatchException ex)
        {
            System.err.println("Error, you should enter a digit");
            System.exit(1);
        }
 
        try
        {
            System.out.println("fibonachi №"+ num +" = " +fibonachi(num));
        }
        catch (IllegalArgumentException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(3);
        }
 
    }
 
    public  static BigInteger factorial (BigInteger n)
    {
        if (n.compareTo(BigInteger.valueOf(0)) == -1)  throw new IllegalArgumentException("Error, number should be positive");
        return ((n.compareTo(BigInteger.valueOf(0)) == 0)||(n.compareTo(BigInteger.valueOf(1))==0)) ? BigInteger.valueOf(1) : n.multiply(factorial( n.add(BigInteger.valueOf(-1))));
    }
 
 
 
    public static BigInteger fibonachi(int n)
    {
        if(n < 0) throw new IllegalArgumentException("Error, number should be positive");
 
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
 
        while (n--!=0)
        {
            BigInteger temp = b;
            b=a.add(b);
            a=temp;
        }
        return a;
    }
 
}
