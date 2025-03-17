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
    
    boolean present(ArrayList<ArrayList<Integer>>adj,int start,boolean []vis){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{start, -1});
        vis[start]=true;
    while(!q.isEmpty()){
        int []node=q.remove();
        int currNode=node[0];
        int parentNode=node[1];
        for(int i=0; i<adj.get(currNode).size(); i++){
            int nebNode=adj.get(currNode).get(i);
            if(vis[nebNode]==false){
                q.add(new int[]{nebNode,currNode});
                vis[nebNode]=true;
            }
            else if(vis[nebNode]==true && nebNode!=parentNode)
            return true;
        }
    }
    return false;
    }
  public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
      boolean []vis=new boolean[adj.size()];
      for(int i=0;i<adj.size(); i++){
          if(vis[i]==false)
          {
              if(present(adj,i,vis))
              return true;
          }
      }
      return false;
    }
}

