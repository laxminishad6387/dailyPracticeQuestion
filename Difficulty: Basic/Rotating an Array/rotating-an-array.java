//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            new Solution().leftRotate(nums, d);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void leftRotate(int arr[], int d) {
       ArrayList<Integer>temparr=new ArrayList<>();
       for(int i=0; i<d; i++)
       temparr.add(arr[i]);
       int j=0;
       for(int i=d; i<arr.length; i++)
       {
           arr[j]=arr[i];
           j++;
       }
       int idx=0;
       for(int i=j; i<arr.length; i++)
       {
       arr[i]=temparr.get(idx);
       idx++;
       }
      
    }
}
