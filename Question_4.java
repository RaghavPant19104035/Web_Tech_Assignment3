package assignment_3;

import java.util.Scanner;

public class Question_4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); 
		
		System.out.print("Enter a positive integer : ");
		int n = scn.nextInt(); // input number 
		System.out.print("Hailstone sequence for the number " + n + " is : ");
		System.out.print(n);
		
		while(n != 1) { // loop continues till n is equal to 1
			if(n % 2 == 0) { // n is divided by 2 then change n to n/2
				n = n/2;
				System.out.print(", " + n);
			}
			else {
				n = 3 * n + 1; // else update n to 3n+1
				System.out.print(", " + n);
			}
		}
	}
}
