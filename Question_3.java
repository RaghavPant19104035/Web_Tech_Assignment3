package assignment_3;

import java.util.*;

public class Question_3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("enter string : ");
		String s = scn.nextLine(); // input string
		
		char[] chars = s.toCharArray(); // string to char array
		Arrays.sort(chars); // sort char arrays lexicographically
		
		String s1 = "";
		for(char ch : chars)
			s1 += ch; // add each character to new string s1 in sorted order
		
		System.out.println("sorted string : " + s1); // sorted string as output
		
	}
}
