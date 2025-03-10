//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
       int firstmax=Integer.MIN_VALUE;
       int secondmax=Integer.MIN_VALUE;
       for(int i=0; i<arr.length; i++)
       {
           if(arr[i]>firstmax){
             
               firstmax=arr[i];
                        
           }
           else if(arr[i]>secondmax && arr[i]<firstmax)secondmax=arr[i];
       }
       if(secondmax<0)
       return -1;
       return secondmax;
    }
}