//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int longestStringChain(String words[]) {
        // Sort words by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // DP HashMap to store longest chain ending at each word
        HashMap<String, Integer> dp = new HashMap<>();
        int maxChain = 1;

        for (String word : words) {
            int longest = 1; // Default length is 1 (word itself)
            
            // Try removing each character to find predecessors
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    longest = Math.max(longest, dp.get(predecessor) + 1);
                }
            }
            
            // Update DP table and maximum chain length
            dp.put(word, longest);
            maxChain = Math.max(maxChain, longest);
        }
        
        return maxChain;
    }
}
