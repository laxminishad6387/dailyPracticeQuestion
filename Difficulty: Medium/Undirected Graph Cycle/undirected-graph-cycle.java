//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
   boolean  isPresent(ArrayList<ArrayList<Integer>>adj,int currNode,int parent,boolean []vis){
       vis[currNode]=true;
       for(int i=0; i<adj.get(currNode).size(); i++)
       {
           int nebNode=adj.get(currNode).get(i);
        //   case 1
            if(vis[nebNode]==true && nebNode!=parent){
                return true;
            }
            // case 2
            else if(vis[nebNode]==false){
                if( isPresent(adj,nebNode,currNode,vis))
                return true;
            }
       }
       return false;
   }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
       boolean vis[]=new boolean[adj.size()];
       int parent=-1;
       for(int i=0; i<adj.size(); i++){
           if(vis[i]==false){
               if(isPresent(adj,i,parent,vis))
               return true;
           }
       }
       return false;
      
       
    }
}

