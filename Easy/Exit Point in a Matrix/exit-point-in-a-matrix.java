//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int i=0, j =0;
       int dir = 0;
       while(true){
           dir=(dir+matrix[i][j])%4;
           
           if(matrix[i][j]==1){
               matrix[i][j]=0;
           }
        //Movement inside matrix
           //move forward
           if(dir == 0)
               j++;
               
            //move down
           else if(dir == 1)
              i++;
              
            // move left
           else if(dir == 2)
              j--;
              
            //move right 
           else if(dir == 3)
              i--;
              
        //edge cases
          if(i < 0 ){
              i++;
              break;
          }
          
          else if(i == n){
              i--;
              break;
          }
          
          else if(j < 0){
              j++;
             break;  
          }
          
          else if(j == m){
              j--;
              break;
          }
        }
                 
          int[] ans = new int[]{i,j};
          return ans;
    }
}