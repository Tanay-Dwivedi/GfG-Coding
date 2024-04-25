//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends
class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        int result = -1;
        if(n < 3 || m < 3){
            return result;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(i-1 >=0 && i+1 < n && j-1 >=0 && j+1 < m){
                    int temp = mat[i][j] + mat[i-1][j-1] + mat[i-1][j] + mat[i-1][j+1] + mat[i+1][j-1] + mat[i+1][j] + mat[i+1][j+1];
                    result = Math.max(result,temp);
                }
            }
        }
        return result;
    }
};