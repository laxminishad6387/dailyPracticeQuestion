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
            if (new Solution().isCyclic(list) == true)
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
     
     boolean isPresent(ArrayList<ArrayList<Integer>>adj,int currNode,boolean []vis,boolean []rec){
         vis[currNode]=true;
         rec[currNode]=true;
         for(int i=0; i<adj.get(currNode).size(); i++){
             int nebNode=adj.get(currNode).get(i);
             if(rec[nebNode]==true)
              return true;
              else if(vis[nebNode]==false){
                 if(isPresent(adj,nebNode,vis,rec))
                 return true;
               
              }
         }
         rec[currNode]=false;
         return false;
     }
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
      boolean vis[]=new boolean[adj.size()];
      boolean rec[]=new boolean[adj.size()];
      for(int i=0; i<adj.size(); i++){
          if(vis[i]==false)
         if( isPresent(adj,i,vis,rec))
         return true;
      }
      return false;
    }
}