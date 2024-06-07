//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            // taking size of array
            int n = Integer.parseInt(br.readLine().trim());
            int l[] = new int[n];
            int r[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to array L
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int maxx = Integer.MIN_VALUE;

            // adding elements to array R
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(inputLine[i]);
                if (r[i] > maxx) {
                    maxx = r[i];
                }
            }

            Solution obj = new Solution();

            // calling maxOccured() function
            System.out.println(obj.maxOccured(n, l, r, maxx));
        }
    }
}


// } Driver Code Ends


class Solution {
    public static int maxOccured(int n, int left[], int right[], int maxx) {
        int[] pre = new int[maxx+1];
        for(int i=0;i<n;i++){
            pre[left[i]]++;
            if(right[i]+1 <= maxx)
            pre[right[i]+1]--;
        }
        int max=0;
        int v=0;
        for(int i=1;i<=maxx;i++){
            pre[i]+=pre[i-1];
            if(max<pre[i]){
                max=pre[i];
                v=i;
            }
        }
        return v;
    }
}



//{ Driver Code Starts.

// } Driver Code Ends