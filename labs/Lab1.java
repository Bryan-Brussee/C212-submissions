
public class Lab1 {

	public static void main( String[] params) {
		System.out.println("Hello World!");
		System.out.println( factorial(7) );
		System.out.println( fibonacci(9) );
		/*
		int i = 1;
		while (i < 20 ) {
			System.out.println( fibonacci(i) );
			i++;
		}
		*/
		
		for (int i=1; i < 20; i++) {
			System.out.println( fibonacci(i) );
		}
	}
	
	public static int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci (n - 2);
		}
	}
	
	
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
			} else {
				return n * factorial( n-1 );
			}
	}
	
}

