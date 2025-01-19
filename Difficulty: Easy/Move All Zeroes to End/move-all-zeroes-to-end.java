//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        int count=0;
        int curr=0;
        // int ans[]=int [arr.length];
     for(int i=0; i<arr.length; i++)
     {
           if(arr[i]==0)
         count++;
       else  if(arr[i]!=0)
         {
            arr[curr]=arr[i];
            curr++;
         }
        
     }
     for(int i=arr.length-count; i<arr.length; i++)
     {
         arr[i]=0;
     }
    }
}