//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
       int maxLength=0;
      
       Stack<Integer> stack=new Stack<>();
       stack.push(-1);
       for(int i=0; i<s.length(); i++)
       {
           if(s.charAt(i)=='(') //open bracket does not check anything . it directly push in the stack
           stack.push(i);
            else {
               stack.pop(); // pop top '( ' or index
               if(!stack.isEmpty())
               {
                   maxLength=Math.max(maxLength,i-stack.peek());
               }
               else
                stack.push(i);
           }
          
           
       }
       
       return maxLength;
    }
}