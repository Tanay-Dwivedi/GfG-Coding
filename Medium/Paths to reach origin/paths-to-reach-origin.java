//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public static int ways(int n, int m)
    {
        // complete the function
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        
        return task(n, m, dp);
    }
    
    static int task(int x, int y,  int[][] dp) {
        if(x < 0 || y < 0) return 0;
        
        if(x == 0 && y == 0) return 1;
        
        if(dp[x][y] != -1) return dp[x][y];
        
        return dp[x][y] = (task(x - 1, y, dp) + task(x, y - 1, dp)) % 1000000007;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends