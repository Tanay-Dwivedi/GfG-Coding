//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        boolean dp[]=new boolean[n+1];
        dp[1]=true;
        for(int i=2;i<=n;i++)
        {
            dp[i]=!dp[i-1];
            if(!dp[i]&&i>=x)
                dp[i]=!dp[i-x];
            if(!dp[i]&&i>=y)
                 dp[i]=!dp[i-y];
        }
         return dp[n] ? 1 : 0;
    }
}