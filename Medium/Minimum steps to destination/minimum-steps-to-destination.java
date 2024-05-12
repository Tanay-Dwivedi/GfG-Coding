//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int minSteps(int d) {
        if(d==0) 
        return 0;
        int pos = 0, steps=0;
        while(pos<d ||(pos-d)%2!=0){
            steps++;
            pos=pos+steps;
        }
        return steps;
    }
}