//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


// import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = 0;
        int maxLen = 0, startIdx = 0;
        
        // TreeMap maintains elements in sorted order, allowing quick min/max retrieval
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        while (right < n) {
            // Insert arr[right] into the frequency map
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            // Check the condition
            while (!map.isEmpty() && (map.lastKey() - map.firstKey()) > x) {
                // Remove arr[left] from map
                if (map.get(arr[left]) == 1) {
                    map.remove(arr[left]);
                } else {
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++; // Shrink window
            }
            
            // Update max length and starting index
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
            
            right++; // Expand window
        }
        
        // Extract the longest valid subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}



//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends