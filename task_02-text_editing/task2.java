package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.printf("Please enter a number of character : ");

        int num =0;
        String c;
        try
        {
            num = in.nextInt();
        }
        catch ( InputMismatchException ex)
        {
            System.err.println("Error , please enter a digit!");
            System.exit(1);
        }

        if (num <= 0)
        {
            System.err.println("Error, index number must be a positive and  not equals zero ");
            System.exit(2);
        }

        System.out.printf("Please enter a character : ");

        c = in.next();

        if (c.length() > 1)
        {
            System.err.println("You should enter only one symbol");
            System.exit(3);
        }

        in.close();

        StringBuilder sb = new StringBuilder();

        try(FileInputStream fin = new FileInputStream("C:\\Users\\Василий\\IdeaProjects\\lab 02\\src\\com\\company\\input"))
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(fin));

            String str ;

            while ((str = bf.readLine()) != null)
            {
                int k =0;
                for (char ch : str.toCharArray())
                    sb.append((k = (ch == ' ' ? 0 : k + 1)) == num ? c : ch);
            }

        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        System.out.println(sb);
    }
 }
