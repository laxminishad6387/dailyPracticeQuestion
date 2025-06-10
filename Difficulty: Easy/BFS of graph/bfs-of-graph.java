class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
       ArrayList<Integer> result=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
       boolean vis[]=new boolean[adj.size()];
       q.add(0);
       while(!q.isEmpty()){
           int currNode=q.remove();
           if(vis[currNode]==false){
               vis[currNode]=true;
               result.add(currNode);
               for(int i=0; i<adj.get(currNode).size(); i++){
                   q.add(adj.get(currNode).get(i));
               }
           }
       }
       return result;
        
    }
}