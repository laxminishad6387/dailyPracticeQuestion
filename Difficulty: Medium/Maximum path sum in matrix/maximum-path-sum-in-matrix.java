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
    // down move
    void downmove(int row, int col,int [][]mat, int [][]newmat)
    {
    newmat[row+1][col]=Math.max(newmat[row+1][col],newmat[row][col]+mat[row+1][col]);
    return;
    }
    // move right diagonal
    void rightdiagonalmove(int row,int col,int [][]mat,int [][]newmat)
    {
    newmat[row+1][col+1]=Math.max(newmat[row+1][col+1],newmat[row][col]+mat[row+1][col+1]);
      return;
    }
    // move left diagonal
    void leftdiagonalmove(int row,int col,int [][]mat,int [][]newmat)
    {
     newmat[row+1][col-1]=Math.max(newmat[row+1][col-1],newmat[row][col]+mat[row+1][col-1]);
      return ;
    }
    
    
    public int maximumPath(int[][] mat) {
        int n=mat.length; //number of rows
        int m=mat[0].length; //number of columns
      int newmat[][]=new int[n][m];
      
      for(int i=0; i<m; i++)
        newmat[0][i]=mat[0][i]; 
        
       for(int i=0; i<n-1; i++)
       {
           for(int j=0; j<m; j++)
           {    
                if(j>0 )
                  leftdiagonalmove(i,j,mat,newmat);
                  downmove(i, j,mat, newmat);
               if(j<m-1) //check row index, col index, roe last index
                 rightdiagonalmove(i,j,mat,newmat);
                  
                 
           }
       }
        int max = newmat[n - 1][0];
        for (int i = 1; i < m; i++)
            max = Math.max(max, newmat[n - 1][i]);
            return max;
       
      
    }
}