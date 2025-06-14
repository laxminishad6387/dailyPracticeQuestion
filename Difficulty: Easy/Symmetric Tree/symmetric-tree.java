/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    boolean check(Node root1, Node root2){
        if(root1==null && root2==null)
         return true;
         else if(root1==null || root2==null)
         return false;
         else if(root1.data!=root2.data)
          return false;
          return check(root1.left, root2.right) && check(root1.right , root2.left);
         
    }
    public boolean isSymmetric(Node root) {
        if(root==null)
        return true;
     return  check(root.left, root.right);
        
    }
}