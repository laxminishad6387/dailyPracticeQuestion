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
    
    public boolean  cycleDetection(ArrayList<ArrayList<Integer>>arr,boolean []vis,int curr,int parent){
        vis[curr]=true;
        for(int i=0; i<arr.get(curr).size(); i++)
        {
            int nei=arr.get(curr).get(i);
            if(parent!=nei && vis[nei]==true)
              return true;
            if(vis[nei]==false)
            {
             if( cycleDetection(arr,vis,nei,curr))
               return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> arr) {
        boolean vis[]=new boolean[arr.size()];
        for(int i=0; i<arr.size(); i++)
        {
            if(vis[i]==false)
            { 
                if(cycleDetection(arr,vis,i,-1))
                  return true;
            }
        }
        return false;
      
    }
}