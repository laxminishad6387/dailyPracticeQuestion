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

// solve using dp approch 


class Solution {
    int MOD=100000007;
    public int countBT(int h) {
       if(h<=1)
         return h;
         int dp[]=new int[h+1];
         dp[0] = 1;
        dp[1] = 1;
         
        for(int i = 2; i <= h; ++i) 
            dp[i] = (dp[i - 1] * ((2 * dp [i - 2])% MOD + dp[i - 1]) % MOD) % MOD;
             
            return dp[h];
       
    }
}
