//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends






// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
         // Step 1: Sort the array
         int n=arr.length;
        Arrays.sort(arr);
        
        // Step 2: Initialize the result with the difference of the tallest and shortest tower before modification
        int result = arr[n - 1] - arr[0];
        
        // Step 3: Traverse the sorted array
        for (int i = 1; i < n; i++) {
            // If decreasing the height by k makes it negative, skip this case
            if (arr[i] - k < 0) continue;
            
            // Calculate the possible minimum and maximum heights
            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            int maxHeight = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            
            // Update the result with the minimum difference
            result = Math.min(result, maxHeight - minHeight);
        }
        
        return result;
    }
}
