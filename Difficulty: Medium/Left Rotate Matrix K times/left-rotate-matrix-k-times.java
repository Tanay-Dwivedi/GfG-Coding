//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends

class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int arr[][]=new int[n][m];
        k=k%m;
        if(k==0) return mat;
        for(int i=0;i<n;i++)
        {
            int x=0;
            for(int j=k;j<m;j++)
            {
                arr[i][x]=mat[i][j];
                x++;
            }
            for(int p=0;p<k;p++)
            {
                arr[i][x]=mat[i][p];
                x++;
            }
        }
        return arr;
    }
}