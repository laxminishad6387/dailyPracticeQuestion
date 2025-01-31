//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

class gfg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(mat));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maximumPath(int[][] arr) {
     int m=arr.length; //number of rows
     int n=arr[0].length; // number of columns
     int ans[][]=new int[m][n];  //create another matrix
     for(int i=0; i<m; i++)
     {
         for(int j=0; j<n; j++)
          ans[i][j]=arr[i][j];
     }
     for(int i=0; i<m; i++)
     {
        for(int j=0; j<n; j++)
        {
            if(j>0  && i<m-1)  //handle left diagonal //arr[i+1][j-1]
            {
                int sum=ans[i][j]+arr[i+1][j-1];
                if(sum>ans[i+1][j-1])
                  ans[i+1][j-1]=sum;
            }
           
            if(i<m-1)//handle down pointer  //arr[i+1][j]
            {
                int sum=ans[i][j]+arr[i+1][j];
                if(sum>ans[i+1][j])
                  ans[i+1][j]=sum;
            }
            if(j<n-1 && i<m-1)//handle right diagonal //arr[i+1][j+1]
            {
                int sum=ans[i][j]+arr[i+1][j+1];
                if(sum>ans[i+1][j+1])
                  ans[i+1][j+1]=sum;
            }
            
        }
     }
     int max=ans[m-1][0];
      for(int i=1; i<n; i++)
      {
          if(ans[m-1][i]>max)
         max=ans[m-1][i];
      }
      return max;
    }
}