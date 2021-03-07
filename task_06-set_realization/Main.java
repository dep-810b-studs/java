package com.company;
 
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main
{
 
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
 
        System.out.print("Please enter a number of sets : ");
 
        int n = 0;
 
        try
        {
            n = in.nextInt();
        }
        catch (InputMismatchException ex)
        {
            System.err.println("This character cant be a number of sets");
            System.exit(1);
        }
 
        if(n <= 0)
        {
            System.err.println( n +  "cant be a number of sets");
            System.exit(1);
        }
 
        in.close();
 
        ArrayList<SeT> sets = new ArrayList<>();
 
        for(int i = 0; i < n; ++i)
        {
            try (FileInputStream fin = new  FileInputStream("C:\\Users\\Василий\\IdeaProjects\\lab 06\\src\\com\\company\\set" + i))
            {
                ArrayList<Integer> temp = new ArrayList<>();
 
                BufferedReader br = new BufferedReader(new InputStreamReader(fin));
 
                String strLine ;
 
                while ((strLine = br.readLine())!= null)
                        temp.add(new Integer(strLine));
 
                sets.add(new SeT(temp));
            }
            catch(IOException ex)
            {
                System.err.println(ex.getMessage());
                System.exit(1);
            }
        }
 
        System.out.println(SeT.intersection(sets));
        System.out.println(SeT.union(sets));
    }
}
