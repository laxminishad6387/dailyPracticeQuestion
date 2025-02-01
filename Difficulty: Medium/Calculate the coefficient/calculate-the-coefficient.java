//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.permutationCoeff(n,k);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java


//DP PROBLEM
class Solution
{
      private static final int MOD = 1000000007;
    public int permutationCoeff(int n, int k)
    {
       long result=1;
        for(int i=0; i<k; i++)
         result=(result*(n-i))%MOD;
         return (int)result;
        
    }
}