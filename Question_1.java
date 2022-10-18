package assignment_3;

import java.util.Scanner;

public class Question_1 {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("enter string 1 : ");
		String s1 = scn.nextLine(); 
		
		System.out.print("enter string 2 : ");
		String s2 = scn.nextLine();
		
		int compare = 0; 
		for(int i=0 ; i<s1.length() || i<s2.length(); i++) {
			if(s1.charAt(i) > s2.charAt(i)) { // character of s1 is lexicographically bigger than character of s2 at a particular index
				compare = 1;
				break;
			}
			else if(s1.charAt(i) < s2.charAt(i)) { // character of s1 is lexicographically smaller than character of s2 at a particular index
				compare = -1;
				break;
			}
		}
		
		if(compare == 1) { 
			System.out.println(s1 + " is lexicographically bigger than " + s2); 
		}
		else if(compare == -1) {
			System.out.println(s1 + " is lexicographically smaller than " + s2);	
		}
		else { // if compare = 0 then we have to check whether both string size equal or not to confirm that both are lexicographically equal
				if(s1.length() > s2.length()) { 
					System.out.println(s1 + " is lexicographically bigger than " + s2);				
				}
				else if(s1.length() < s2.length()) {
					System.out.println(s1 + " is lexicographically smaller than " + s2);	
				}
				else {
					System.out.println(s1 + " is lexicographically equal to " + s2);
				}
			}
	}

}
