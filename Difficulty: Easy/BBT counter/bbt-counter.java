//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read the number of test cases

        while (t-- > 0) {
            int h = sc.nextInt(); // Read the height
            Solution ob = new Solution();
            System.out.println(ob.countBT(h)); // Output the result
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User-defined Solution class

class Solution {
    public int countBT(int h) {
       if(h==1)
       return 1;
       if(h==2)
       return 3;
       int dp[]=new int[h+1];
       dp[0]=1;
       dp[1]=3;
       for(int i=2; i<h; i++)
         dp[i]=dp[i-1]*dp[i-1]+2*dp[i-1]*dp[i-2];  
       return dp[h-1];
    }
}
