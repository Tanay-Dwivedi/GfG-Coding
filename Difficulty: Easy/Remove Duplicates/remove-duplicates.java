//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    String removeDups(String str) {
        String s = "";
        for(int i = 0; i < str.length(); i++){
            String ch = ""+str.charAt(i);
            if(!s.contains(ch))
                s+=ch;
        }
        return s;
    }
}