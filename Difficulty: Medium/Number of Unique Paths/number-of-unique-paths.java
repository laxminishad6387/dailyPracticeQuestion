//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java
// solve using dp approch
class Solution
{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int m, int n) 
    {
        int mat[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j];
                }
            }
        }
        return mat[m - 1][n - 1];
 
    }
}