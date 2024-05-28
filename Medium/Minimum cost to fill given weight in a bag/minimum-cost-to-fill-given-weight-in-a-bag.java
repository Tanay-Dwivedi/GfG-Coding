//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    
    static int helper(int ind, int w, int[] cost, int[][] dp){
        
        
        if(ind < 0)
            return Integer.MAX_VALUE;
        if(w == 0)
            return 0;
        
        if( w < 0)
            return Integer.MAX_VALUE;
            
        if(dp[ind][w] != -1){
            return dp[ind][w];
        }
        int take = Integer.MAX_VALUE;
        if(ind + 1  <= w){
            take = cost[ind] + helper(ind, w - (ind + 1), cost, dp);
        }
        
        int not = helper(ind - 1, w, cost, dp);
        
        return dp[ind][w] = Math.min(take, not);
    }
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        
        int [][] dp = new int[n + 1][w+1];
        
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < w + 1; j++)
                dp[i][j] = -1;
        }
        
       return helper(n-1, w, cost, dp);
    }
}