//{ Driver Code Starts
// Initial Template for Java

// INITIAL CODE
import java.io.*;
import java.lang.*;
import java.util.*;

// A Binary Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Is_Leaves_At_Same_Level {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    // driver function to test the above functions
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution g = new Solution();
            boolean b = g.check(root);
            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    boolean check(Node root) {
       Queue<Node> q=new LinkedList<>();
       int leaflevel=-1;
       int level=0;
       boolean leaf=false;
       q.add(root);
       while(!q.isEmpty())
       {
           int n=q.size();
           level++;
           for(int i=0; i<n; i++)
           {
               Node ele=q.remove();
            //   case 1: here we check that all leaf are in same level or not
               if(ele.left==null && ele.right==null)
               {
                   if(leaf==false)
                   {
                       leaf=true;
                       leaflevel=level;
                   }
                   else if(leaf==true && level!=leaflevel)
                    return false;
               }
               else {
                   if(ele.left!=null)
                    q.add(ele.left);
                    if(ele.right!=null)
                     q.add(ele.right);
               }
           }
           
       }
       return true;
    }
}
