//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    void nextPermutation(int[] arr) {
    //  step 1
      int gola_index=-1;
    //   find gola index
      for(int i=arr.length-1; i>0; i--)
      {
         if(arr[i]>arr[i-1])
         {
          gola_index=i-1;
          break;
         }
      }
      int greater_index=gola_index;
      if(gola_index!=-1)
      {
        //   find greater index value
          for(int i=arr.length-1; i>0; i--)
          {
              if(arr[i]>arr[gola_index])
                {
                    greater_index=i;
                    break;
                }
          }
        //   interchange the gola_index value to greater_index value
        int temp=arr[gola_index];
        arr[gola_index]=arr[greater_index];
        arr[greater_index]=temp;
      }
       
    //   reverse the value after the gola_index
    int j=0;
    for(int i=gola_index+1; i<=(gola_index+arr.length)/2; i++)
    {
        int temp=arr[i];
        arr[i]=arr[arr.length-1-j];
        arr[arr.length-1-j]=temp;
        j++;
    }
    }
}



//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends