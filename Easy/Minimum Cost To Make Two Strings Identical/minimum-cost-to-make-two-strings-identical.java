//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
	    int n = y.length();
	    int[]prev = new int[n+1];
        int[]curr= new int[n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                    
                }else{
                    curr[j]= Math.max(curr[j-1],prev[j]);
                }
            }
            prev = Arrays.copyOf(curr,n+1);
        }
        int lcs = curr[n];
        int c1 = m-lcs;
        int c2 = n-lcs;
        int cost = (c1*costX) + (c2*costY);
        return cost;
    }
}