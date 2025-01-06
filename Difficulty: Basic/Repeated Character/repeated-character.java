//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String s)
    {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
             map.put(s.charAt(i), 1);
        }
        for(int i=0; i<s.length(); i++)
        {
            if(map.get(s.charAt(i))>=2)
              return s.charAt(i);
        }
        return '#';
    }
}