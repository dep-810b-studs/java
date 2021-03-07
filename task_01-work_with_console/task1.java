package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {
	System.out.print("Please enter a number of strings what do you want to enter : ");

	Scanner in = new Scanner(System.in);
	int n =  0;
	try
	{
		n = in.nextInt();
	}
	catch (InputMismatchException ex)
	{
		System.err.print("Error! Please enter a digit!");
		System.exit(1);
	}

	if(n<=0)
	{
		System.err.println("Error! Please enter a positive digit");
		System.exit(2);
	}

	String [] s = new String[n];
	System.out.printf("Please enter string :\n");

	double middleLength = 0;

	for(int i = 0; i < n; ++i) 
		middleLength+= (s[i] = in.next()).length();

	middleLength/=n;

	for (String x : s) 
		if (x.length() < middleLength) 
			System.out.printf("String : %s Length = %d \n ",x,x.length());
    }
}
