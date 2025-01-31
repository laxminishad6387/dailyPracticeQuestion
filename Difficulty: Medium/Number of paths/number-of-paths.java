//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int m = Integer.parseInt(inputLine[0]);
            int n = Integer.parseInt(inputLine[1]);
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int numberOfPaths(int m, int n) {
      int arr[][]=new int[m][n];    // craete m*n  size matrix 
      for(int i=0; i<m; i++)       //  put  1 to all rows
       arr[i][0]=1;
       for(int i=0; i<n; i++)     //put 1 to all columns
        arr[0][i]=1;
       for(int i=1; i<m; i++)
       {
           for(int j=1; j<n; j++)
            arr[i][j]=arr[i-1][j]+arr[i][j-1];
           
       }
       return arr[m-1][n-1];
    }
}