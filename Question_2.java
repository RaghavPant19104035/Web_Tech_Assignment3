package assignment_3;

import java.util.Scanner;

public class Question_2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("enter the array size : ");
		int size = scn.nextInt();
		
		int[] arr = new int[size];
		int[] helper = new int[size]; // helper array store sorted arr elements
		
		for(int i=0 ; i<size ; i++) { // array element should be between 0 and 20
			System.out.print("enter " + i + "th array element value should be positive and less than 21 : ");
			arr[i] = scn.nextInt();
		}
		
		int[] count = new int[21]; // count array store count of each arr element
		
		for(int i=0 ; i<size ; i++) {
			count[arr[i]]++;  // maintains frequency of each ith arr element at arr[i] index of count array 
		}
		
		for(int i=1 ; i<=20 ; i++) {
			count[i] += count[i-1]; // count[i] contains ith element position which is count[i]-1 index
		}
		
		for(int i=size-1 ; i>=0 ; i--) {
			helper[--count[arr[i]]] = arr[i]; // here we are placing sorted elements in helper array
		}
		
		for(int i=0 ; i<size ; i++) {
			arr[i] = helper[i]; // arr array gets sorted elements with the help of helper array
		}
		
		System.out.println("sorted output array :");
		for(int i=0 ; i<size ; i++) {
			System.out.print(arr[i]);
			
			if(i == size-1)
				System.out.print(". ");
			else 
				System.out.print(", ");
		}
		
	}
}
