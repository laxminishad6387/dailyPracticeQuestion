//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Add root (if not leaf)
        if (!isLeaf(root)) {
            result.add(root.data);
        }

        // Add left boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // Add leaf nodes (from both left and right subtrees)
        addLeaves(root, result);

        // Add right boundary (excluding leaves) in reverse order
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    private void addLeftBoundary(Node root, ArrayList<Integer> result) {
        Node curr = root;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.data);
            }
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    private void addLeaves(Node root, ArrayList<Integer> result) {
        if (root == null) return;

        if (isLeaf(root)) {
            result.add(root.data);
        }
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    private void addRightBoundary(Node root, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        Node curr = root;
        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
