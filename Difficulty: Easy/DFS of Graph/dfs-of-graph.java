class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
     public void dfsOfGraph(ArrayList<ArrayList<Integer>> graph,int currNode ,boolean vis[] , ArrayList<Integer> result) {
      
       result.add(currNode);
       vis[currNode]=true;
       for(int i=0; i<graph.get(currNode).size(); i++){
           int node=graph.get(currNode).get(i);
           if(!vis[node])
           {
               dfsOfGraph(graph, node, vis, result); 
           }
       }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
      
        ArrayList<Integer> result=new ArrayList<>();
        boolean vis[]=new boolean[adj.size()];
        dfsOfGraph(adj, 0, vis, result);
        return result;
    }
    
}