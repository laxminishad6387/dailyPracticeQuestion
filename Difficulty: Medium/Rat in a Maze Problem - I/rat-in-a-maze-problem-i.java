//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    public void backtracking( ArrayList<String>result,int r,int c, ArrayList<ArrayList<Integer>> m,int n,String str,boolean [][]vis)
    {
        if(r==n-1 && c==n-1)
        {
            result.add(str);
            return;
        }
        if(r>=0 && c>=0 && r<n && c<n)
        {
            if(vis[r][c]==true || m.get(r).get(c)==0)
            return;
            vis[r][c]=true;
              backtracking(result,r+1,c,m,n,str+'D',vis);
              backtracking(result,r,c-1,m,n,str+'L',vis);
              backtracking(result,r,c+1,m,n,str+'R',vis);
              backtracking(result,r-1,c,m,n,str+'U',vis);
              vis[r][c]=false;
        }
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> m) {
        ArrayList<String> result=new ArrayList<>();
        int n=m.size();
       
        boolean [][]vis=new boolean[n][n];
        backtracking(result,0,0,m,n,"",vis);
        return result;
    }
}