//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the line of integers (prices)
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int maximumProfit(int arr[]) {
        // base condition 
        if(arr.length==1)
         return 0;
         int min=arr[0];
         int max=0;
         int maxprofit=0;
         int flag=0;
         for(int i=1; i<arr.length; i++)
         {
             if(arr[i]-min<max)
             {
                flag=1;
                min=arr[i];
                maxprofit+=max;
                max=0;
             }
             else 
             {
                 flag=0;
                 max= arr[i]-min;
             }
         }
         if(flag==0)
         {
             maxprofit+=max;
             return maxprofit;
         }
         else 
         return maxprofit;
    }
}