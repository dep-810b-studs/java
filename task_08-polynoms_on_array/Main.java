
package com.company;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main
{
 
    public static void main(String[] args)
    {
        Polynom a = new Polynom();
        Polynom b = new Polynom();
 
        try(FileInputStream fin = new FileInputStream("C:\\Users\\Василий\\IdeaProjects\\lab 08\\src\\polynom1"))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String strLine ;
            while ((strLine = br.readLine()) != null)
                try
                {
                    a.add(new Integer(strLine.split(" ")[1]), new Integer(strLine.split(" ")[0]));
                }
                catch (NumberFormatException ex)
                {
                    System.err.println(ex.getMessage() + " Should be a number");
                    System.exit(1);
                }
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
 
        try(FileInputStream fin = new FileInputStream("C:\\Users\\Василий\\IdeaProjects\\lab 08\\src\\polynom2"))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String strLine ;
            while ((strLine = br.readLine()) != null)
                try
                {
                    b.add(new Integer(strLine.split(" ")[1]), new Integer(strLine.split(" ")[0]));
                }
                catch (NumberFormatException ex)
                {
                    System.err.println(ex.getMessage() + " Should be a number");
                    System.exit(2);
                }
 
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }
 
 
       
       System.out.println(a + " * " + b + " = " + Polynom.multiplication(a,b));
        System.out.println(a + " + " + b + " = " + Polynom.sum(a,b));
    }
}
