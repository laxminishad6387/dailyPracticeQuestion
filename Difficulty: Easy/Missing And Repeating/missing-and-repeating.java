//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
      boolean vis[]=new boolean[arr.length];
      int ans[]=new int[arr.length];
      int repeating=0;
      int missing=0;
      for(int i=0; i<arr.length; i++)
      {
          int index=arr[i]-1;
          if(vis[index]==false)
          {
              vis[index]=true;
          ans[index]=arr[i];
          }
          else
         repeating=arr[i];
      }
      for(int i=0; i<vis.length; i++)
      {
          if(vis[i]==false)
         missing=i+1;
      }
      ArrayList<Integer> result=new ArrayList<>();
      result.add( repeating);
      result.add(missing);
      return result;
    }
}
