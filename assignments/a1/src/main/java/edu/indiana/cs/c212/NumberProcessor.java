package edu.indiana.cs.c212;

import java.util.Scanner;

/*
 * For more details please make sure to check out the wiki. It has detailed instructions
 * about how to complete the assignment.
 */
public class NumberProcessor {
	
	//this method should return the sum all of the numbers between 1 and n
	public static int sumSequence(int i) {
		int sum = 0;
		
		int count = 1;
		while (count <= i)
		{
			sum += count;
			count++;
		}
		return sum;
	}

	//this method should return the sum all of the EVEN numbers between 0 and n
	//example: n=8    :   0 + 2 + 4 + 6 + 8 = 20
	public static int sumEvenSequence(int n) {
		 int sum = 0;
		 
		 int count = 0;
			 while (count <= n)
			 {
				 sum += count;
				 count = count + 2;
			 }
			 return sum;
		 }

	//this method should return the sum all of the ODD numbers between 1 and n
	//example: n=7    :   1 + 3 + 5 + 7 = 16
	public static int sumOddSequence(int n) {
		 int sum = 0;
		 int count = 1;
		 
		 while (count <= n)
		 {
			 sum += count;
			 count = count + 2;
		 }
		 return sum;
	}

	//this method should return the sum all of the PERFECT SQUARES between 1 and n
	//example: n=26    :   1 + 4 + 9 + 16 + 25 = 55
	public static int sumSquaresSequence(int n) {
		 int sum =0;
		 int count = 0;
		 int sqcount = 0;
		 
		 while (sqcount <= n)
		 {
			 sum = sum + sqcount;
			 count++;
			 sqcount = count * count;
		 }
		 return sum;
	}

	public static void main(String[] args)
	{
		System.out.println("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(sumSequence(n));
		System.out.println(sumEvenSequence(n));
		System.out.println(sumOddSequence(n));
		System.out.println(sumSquaresSequence(n));
	}
}
