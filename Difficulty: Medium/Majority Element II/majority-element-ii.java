//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
  public List<Integer> findMajority(int[] arr) {
      HashMap<Integer, Integer> map=new HashMap<>();
    //   step 1 --> count the number 
      for(int i=0; i<arr.length; i++)
      {
          if(map.containsKey(arr[i]))
           map.put(arr[i],map.get(arr[i])+1);
           else
             map.put(arr[i],1);
      }
      List<Integer> ans=new ArrayList<>();
       for(Map.Entry<Integer, Integer> set: map.entrySet())
       {
           if(set.getValue()>arr.length/3)
            ans.add(set.getKey());
       }
       return ans;
    }
}
