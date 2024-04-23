//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int firstElement(int n) {
        // code here
        if(n == 1)  return 1;
        int[][] matrix = {{1,1},{1,0}};
        int[][] resultantmatrix = {{1,1},{1,0}};
        int i=2;
        while(i<=n){
            int[][] tempmatrix = new int[2][2];
            tempmatrix[0][0] = (resultantmatrix[0][0]*matrix[0][0] + resultantmatrix[0][1]*matrix[1][0])%1000000007;
            tempmatrix[0][1] = (resultantmatrix[0][0]*matrix[0][1] + resultantmatrix[0][1]*matrix[1][1])%1000000007;
            tempmatrix[1][0] = (resultantmatrix[1][0]*matrix[0][0] + resultantmatrix[1][1]*matrix[1][0])%1000000007;
            tempmatrix[1][1] = (resultantmatrix[1][0]*matrix[0][1] + resultantmatrix[1][1]*matrix[1][1])%1000000007;
            resultantmatrix[0][0] = tempmatrix[0][0];
            resultantmatrix[0][1] = tempmatrix[0][1];
            resultantmatrix[1][0] = tempmatrix[1][0];
            resultantmatrix[1][1] = tempmatrix[1][1];
            
            i++;
        }
        return (int)resultantmatrix[1][0];
    }
}