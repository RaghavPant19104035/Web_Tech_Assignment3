package assignment_3;

import java.util.*;

public class Question_5 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Input string 1 : ");
		String s1 = scn.nextLine(); // input string 1
		
		System.out.println("Input string 2 : ");
		String s2 = scn.nextLine(); // input string 2
		
		int n = s1.length(), m = s2.length();
		int[][] dp = new int[n+1][m+1]; // 2dp of size n and m
		
		for(int[] d : dp)
			Arrays.fill(d,  -1); // fill dp with -1 as a check whether value is updated here
		
	    memoization_DP(s1, s2, n, m, dp);
	    
	    ArrayList<ArrayList<String>> lists = new ArrayList<>();
	    
	    getAllMethods(s1, s2, new ArrayList<>(), lists, dp);
	    
        for (int i=0 ; i<lists.size(); i++) {
            System.out.println("Method " + (i+1) + " : ");
            for (String s : lists.get(i)) {
                System.out.println(s);
            }
        }
	    
	}
	
    public static int memoization_DP(String s1, String s2, int n, int m, int[][] dp) {
    	if(n == 0)
    		return dp[n][m] = m; // if n=0 then cost would be m (remove all m elements from s2)
    	else if(m == 0)
    		return dp[n][m] = n; // if m=0 then cost would be n (remove all m elements from s1)
    	
    	if(dp[n][m] != -1)
    		return dp[n][m];
    	
    	if(s1.charAt(n-1) == s2.charAt(m-1)) // if s1 and s2 characters are equal
    		return dp[n][m] = memoization_DP(s1, s2, n-1, m-1, dp); 
    	else {
    		
    		int insert = memoization_DP(s1, s2, n, m-1, dp); // insert element in s1
    		int remove = memoization_DP(s1, s2, n-1, m, dp); // remove element in s1
    		int replace = memoization_DP(s1, s2, n-1, m-1, dp); // replace element in s1
    		
    		return dp[n][m] = Math.min(Math.min(insert, remove), replace) + 1; // minimum of insert, remove and replace
    	}
    
    }
    
    public static void getAllMethods(String s1, String s2, ArrayList<String> changes, ArrayList<ArrayList<String>> lists, int[][] dp) {

    	int i = s1.length();
        int j = s2.length();

        while (true) {
            if (i == 0 || j == 0) {
                lists.add(changes); // add the list to lists
                break;
            }
            
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            }
            else {
                boolean if1 = false, if2 = false;
               
                if (dp[i][j] == dp[i - 1][j - 1] + 1) { // replace
                    // Add this step
                    changes.add("Change " + s1.charAt(i - 1) + " to " + s2.charAt(j - 1)); 
                    i--;
                    j--;
        
                    if1 = true;
                }
               
                if (dp[i][j] == dp[i - 1][j] + 1) { // remove
                    if (if1 == false) {
                        changes.add("Delete " + s1.charAt(i - 1));
                        i--;
                    }
                    else {
                        ArrayList<String> changes2 = new ArrayList<String>(); // new list creation
                        changes2.addAll(changes); // add all operations from changes to changes2 list
                        changes2.remove(changes.size() - 1); // remove last operation
                        changes2.add("Delete " + s1.charAt(i));

                        getAllMethods(s1.substring(0, i), s2.substring(0, j + 1), changes2, lists, dp);
                    }
                     if2 = true;
                  }
  
                if (dp[i][j] == dp[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + s2.charAt(j - 1));
                        j--;
                    }
                    else {
 
                        ArrayList<String> changes2 = new ArrayList<String>(); // new list creation
                        changes2.addAll(changes); // add all operations from changes to changes2 list
                        changes2.remove(changes.size() - 1); // remove last operation
                        changes2.add("Add " + s2.charAt(j));
 
                        getAllMethods(s1.substring(0, i + 1), s2.substring(0, j), changes2, lists, dp);
                    }
                }
             }
         }
     }
    
}