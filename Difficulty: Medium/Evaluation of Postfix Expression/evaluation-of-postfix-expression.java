//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends




class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (String s : arr) {
            if (isOperator(s)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                stack.push(applyOperation(a, b, s));
            } else {
                stack.push(Integer.parseInt(s)); // Push numbers onto stack
            }
        }
        
        return stack.pop(); // Final result
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int applyOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division, rounding towards zero
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends