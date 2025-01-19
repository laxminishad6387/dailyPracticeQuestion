//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int d = Integer.parseInt(in.readLine().trim()); // rotation count (key)
            int n = array.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = array.get(i);

            new Solution().rotateArr(arr, d); // rotating the array
            StringBuilder sb = new StringBuilder();

            // printing the elements of the array
            for (int value : arr) sb.append(value).append(" ");
            out.println(sb.toString().trim());

            out.println("~");
        }
        out.flush();
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   static void rotateArr(int arr[], int d) {
       if(arr.length==1)
         return;
    //  case 1
      if(d==arr.length)
       return;
    //   case 2
       else if(d<arr.length)
       {
           int temp[]=new int [d];
           for(int i=0; i<d; i++)
           {
               temp[i]=arr[i];
           }
           int curr=0;
           for(int i=d; i<arr.length; i++)
           {
              arr[curr]=arr[i];
              curr++;
              
           }
           int j=0;
           for(int i=arr.length-d; i<arr.length; i++)
           {
              arr[i]=temp[j];
              j++;
           }
       }
    //   case 3
       else if(d>arr.length)
       {
           d=d%arr.length;
           int temp[]=new int [d];
           for(int i=0; i<d; i++)
           {
               temp[i]=arr[i];
           }
           int curr=0;
           for(int i=d; i<arr.length; i++)
           {
              arr[curr]=arr[i];
              curr++;
              
           }
           int j=0;
           for(int i=arr.length-d; i<arr.length; i++)
           {
              arr[i]=temp[j];
              j++;
           }
       }
       
    }
}