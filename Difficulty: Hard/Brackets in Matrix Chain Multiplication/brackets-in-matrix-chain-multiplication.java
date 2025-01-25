//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    private static int get(int[] p, int n) {
        int[][] m = new int[n][n];
        int ans = 1000000000;

        for (int i = 1; i < n; i++) m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                m[i][i + L - 1] = Integer.MAX_VALUE;

                for (int k = i; k <= i + L - 2; k++) {
                    int q =
                        m[i][k] + m[k + 1][i + L - 1] + p[i - 1] * p[k] * p[i + L - 1];

                    if (q < m[i][i + L - 1]) {
                        m[i][i + L - 1] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    private static int find(String s, int[] p) {
        List<int[]> arr = new ArrayList<>();
        int ans = 0;

        for (char t : s.toCharArray()) {
            if (t == '(') {
                arr.add(new int[] {-1, -1});
            } else if (t == ')') {
                int[] b = arr.remove(arr.size() - 1);
                int[] a = arr.remove(arr.size() - 1);
                arr.remove(arr.size() - 1);
                arr.add(new int[] {a[0], b[1]});
                ans += a[0] * a[1] * b[1];
            } else {
                arr.add(new int[] {p[t - 'A'], p[t - 'A' + 1]});
            }
        }

        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            String result = Solution.matrixChainOrder(nums);
            if (get(nums, numsStr.length) == find(result, nums)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String matrixChainOrder(int arr[]) {
        int n = arr.length;
        long[][] dp = new long[n][n];
        int[][] brackets = new int[n][n];

        // Base case: cost of multiplying one matrix is 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Compute dp[i][j] for chain lengths 2 to n-1
        for (int l = 2; l < n; l++) { // l is the chain length
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + (long) arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        brackets[i][j] = k;
                    }
                }
            }
        }

        // Reconstruct the solution
        return constructOptimalOrder(brackets, 1, n - 1);
    }

    static String constructOptimalOrder(int[][] brackets, int i, int j) {
        if (i == j) {
            return String.valueOf((char) ('A' + i - 1)); // Map indices to A-Z
        }
        int k = brackets[i][j];
        String left = constructOptimalOrder(brackets, i, k);
        String right = constructOptimalOrder(brackets, k + 1, j);
        return "(" + left + right + ")";
    }
}
