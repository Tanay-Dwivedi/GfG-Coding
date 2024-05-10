//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for(int n1 : arr){
            for(int i = k; i >= n1; i--){
                dp[i] += dp[i - n1];
            }
        }
        help(ans, new ArrayList<>(), arr, dp, k, 0);
        return ans;
    }
    
    void help(List<List<Integer>> ans, List<Integer> temp, int[] arr, int[] dp, 
    int rem, int start){
        if(rem < 0) return;
        else if(rem == 0){
            ans.add(new ArrayList<>(temp));
        }
            else{
                for(int i = start; i < arr.length; i++){
                    if(i > start && arr[i] == arr[i - 1]) continue;
                    if(rem < arr[i]) break;
                    temp.add(arr[i]);
                    help(ans, temp, arr, dp, rem - arr[i], i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        
    }
}