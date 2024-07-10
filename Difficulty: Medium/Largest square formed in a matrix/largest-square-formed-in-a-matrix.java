//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int ans=0;
        
        int dp[][] =  new int [n][m];
        for (int  i = 0 ; i < m ;i++){
            dp[0][i]=mat[0][i];
            ans = ans > dp[0][i] ? ans : dp[0][i]; 
            
        }
        for (int  i = 0 ; i < n ;i++){
            dp[i][0]=mat[i][0];
             ans = ans> dp[i][0] ? ans : dp[i][0]; 
            
        }
        
        for ( int x = 1 ; x < n ; x++){
            for ( int  y = 1 ;  y < m  ; y++){
                if ( mat[ x][y] == 0 ){
                    dp[x][y]= 0;
                }
                else{
                    dp[x][y]= 1+ Math.min(dp[x-1][y], Math.min( dp[x-1][y-1] , dp[x][y-1]));
                     ans = ans> dp[x][y] ? ans : dp[x][y]; 
                }
            }
        }
        return ans;
    }
}