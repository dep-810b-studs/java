package com.company;
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main 
{
 
    public static void main(String[] args) 
    {
 
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
 
        try (FileInputStream  fin = new FileInputStream("C:\\Users\\Василий\\IdeaProjects\\lab 07\\src\\com\\company\\input"))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String strLine ;
 
            int counter = 0;
 
            while ((strLine = br.readLine()) != null) {
 
                String[] strs = strLine.split(" ");
 
                ArrayList<Integer> temp = new ArrayList<>();
 
                for (String x : strs)
                    try
                    {
                        temp.add(new Integer(x));
                    }
                    catch (NumberFormatException ex)
                    {
                        System.err.println("Error : please write a digit ! not a different symbol! ");
                        System.exit(1);
                    }
 
                    arr.add(counter++,temp);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
 
        if(arr.size() > 0)
        {
            for(ArrayList<Integer> x : arr)
            {
                if(x.size() > 0)
                {
                    while (x.size()!=1)
                    {
                        ArrayList<Integer> temp = new ArrayList<>();
 
                        for (int i=0;i < x.size() - 1;i++)
                        {
                            System.out.print(x.get(i) + "+" + x.get(i+1) + " ");
                            temp.add(x.get(i)+x.get(i+1));
                        }
                        System.out.println();
                        x = temp;
                    }
 
                    System.out.println(x.get(0));
                }
                else
                    if (x.size()== 1)
                             System.out.println(x.get(0));            }
        }
        else
        {
            System.out.println("Error, file is empty!");
        }
    }
}
