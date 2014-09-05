package edu.indiana.c212.labs.two;

public class Lab2 {
	public static int recursiveAdd(int x, int y){
		//TODO 
		//code to add numbers recursively
		return -1;
	}
	public static int iterativeAdd(int x, int y){
		//TODO  
		//code to add numbers iteratively
		return -1;
	}
	public static int iterativeMult(int x, int y){
		//TODO 
		//code to multiply numbers iteratively 
		return -1;
	}
	public static int iterativeExp(int x, int exp){	
		//TODO
		//code to find exponential of a number iteratively
		return -1;
	}

    public  static void printExpected(Object expected, Object actual){
        System.out.printf("Expected value is : %s, received value was: %s. \n", expected, actual);
    }

	public static void main(String[] args){
		printExpected(4, recursiveAdd(0, 4));//Expected result 4
		printExpected(7, recursiveAdd(3, 4));//Expected result 7
		printExpected(7, iterativeAdd(3, 4));//Expected result 7
		printExpected(12, iterativeMult(3, 4));//Expected result 12
		printExpected(81, iterativeExp(3, 4));//Expected result 81

	}
}