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
      ArrayList<Integer> newarr=new ArrayList<>();
    //   d is less  than array length
    if(d<arr.length)
    {
       
        for(int i=0; i<d; i++)
        newarr.add(arr[i]);
        int j=0;
        for(int i=d; i<arr.length; i++)
        {
            arr[j]=arr[i];
            j++;
        }
        int k=0;
        for(int i=j; i<arr.length; i++)
        {
            arr[i]=newarr.get(k);
            k++;
        }
        
    }
      
    //   d is greater than array length
    if(d>=arr.length)
    {
        int d1=d%arr.length;
       
        for(int i=0; i<d1; i++)
        newarr.add(arr[i]);
        int j=0;
        for(int i=d1; i<arr.length; i++)
        {
            arr[j]=arr[i];
            j++;
        }
        int k=0;
        for(int i=j; i<arr.length; i++)
        {
            arr[i]=newarr.get(k);
            k++;
        }
        
    }
    
     
    }
}