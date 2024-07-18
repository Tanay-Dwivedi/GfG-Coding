//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        // code here
        int up = 1;
        int down = 1;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i + 1] - arr[i] > 0)
                up = down + 1;
            else if (arr[i + 1] - arr[i] < 0)
                down = up + 1;
            i++;
        }
        if (up > down)
            return up;
        else
            return down;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends