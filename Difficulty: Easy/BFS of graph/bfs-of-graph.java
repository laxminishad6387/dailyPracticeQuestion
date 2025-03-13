//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
   public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[V];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr=q.remove();
            if(vis[curr]==false)
            {
               result.add(curr);
               vis[curr]=true;
               for(int i=0; i<adj.get(curr).size(); i++)
               {
                   q.add(adj.get(curr).get(i));
               }
            }
        }
        return result;
    }
}