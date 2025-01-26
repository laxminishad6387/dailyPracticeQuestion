//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
   
    // DFS
    public boolean isCycleDetection(ArrayList<ArrayList<Integer>>arr,boolean []vis,
    int curr,boolean []rec){
       vis[curr]=true;
       rec[curr]=true;
       for(int i=0; i<arr.get(curr).size(); i++)
       {
           int nei=arr.get(curr).get(i);
            if(rec[nei]==true)
             return true;
             if(vis[nei]==false)
             {
                if( isCycleDetection(arr,vis,nei,rec))
                   return true;
             }
       }
       rec[curr]=false;
       return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> arr) {
        boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleDetection(arr, vis, i, rec)) {
                    return true;
                }
            }
        }
        return false;
    }
}