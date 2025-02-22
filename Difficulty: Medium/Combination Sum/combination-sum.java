//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.combinationSum(arr, sum);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                for (ArrayList<Integer> row : ans) {
                    Collections.sort(row);
                }
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() -
                        list2.size(); // If equal, smaller list comes first
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function template for JAVA

class Solution {
   static  ArrayList<ArrayList<Integer>> result=new ArrayList<>();
  static void targetSum(int[]arr,int index, ArrayList<Integer> ans, int target,ArrayList<ArrayList<Integer>>result)
    {
        if(target==0)
         {  
             
             result.add(new ArrayList<>(ans));
             return;
         }
         else if(target<0)
         return;
         for(int i=index; i<arr.length; i++)
         {
            
             ans.add(arr[i]);
             targetSum(arr, i, ans, target-arr[i],result);
             ans.remove(ans.size()-1);
         }
    }
   
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
      Arrays.sort(arr);
      ArrayList<Integer> ans=new ArrayList<>();
       ArrayList<ArrayList<Integer>> result=new ArrayList<>();
      
      targetSum(arr,0,ans, target,result);
    //   if(result.size()==0)
    //   return new ArrayList<>();
       return result;
    }
}