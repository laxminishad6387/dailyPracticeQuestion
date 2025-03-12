//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] a) {
       Arrays.sort(a);
     int floorValue=-1;
     int cellingValue=-1;
     for(int i=0; i<a.length; i++)
     {
      //  find floor value
      if(a[i]<=x && a[i]>=floorValue)
     floorValue=a[i];
      
      
       //  find celling value
      if(a[i]>=x && a[i]>=cellingValue && cellingValue==-1)
      {
        cellingValue=a[i];
         
      }
     }
     int result[]=new int[2];
     result[0]=floorValue;
     result[1]=cellingValue;
     return result;
    
    }
}
