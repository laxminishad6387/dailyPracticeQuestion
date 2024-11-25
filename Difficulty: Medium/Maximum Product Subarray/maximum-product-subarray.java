//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] nums) {
       
       
        if(nums.length==0)
        return 0;
        // condition
        int max=nums[0];
        int min=nums[0];
        int res=nums[0];
        for(int i=1; i<nums.length; i++)
        {
            int curr=nums[i];
            int tempmax=Math.max(curr, Math.max(max*curr, min*curr));
            min=Math.min(curr, Math.min(max*curr, min*curr));
            max=tempmax;
            res=Math.max(res,max);
        }
        return res;
  
    }
}