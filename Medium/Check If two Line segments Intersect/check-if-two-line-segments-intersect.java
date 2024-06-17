//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int p1[] = new int[2];
            int q1[] = new int[2];
            int p2[] = new int[2];
            int q2[] = new int[2];
            String S1[] = read.readLine().split(" ");
            p1[0] = Integer.parseInt(S1[0]);
            p1[1] = Integer.parseInt(S1[1]);
            q1[0] = Integer.parseInt(S1[2]);
            q1[1] = Integer.parseInt(S1[3]);
            String S2[] = read.readLine().split(" ");
            p2[0] = Integer.parseInt(S2[0]);
            p2[1] = Integer.parseInt(S2[1]);
            q2[0] = Integer.parseInt(S2[2]);
            q2[1] = Integer.parseInt(S2[3]);
            Solution ob = new Solution();
            String ans = ob.doIntersect(p1, q1, p2, q2);
            // if(ans)
            System.out.println(ans);
            // else
            // System.out.println("false");
        }
    }
}
// } Driver Code Ends

class Solution {
    float line(int p1[],int q1[],int p2[]){
        float m=((float)q1[1]-p1[1])/((float)q1[0]-p1[0]);

        return (float)p2[1]-p1[1]-m*(p2[0]-p1[0]);
    }
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {

        float val1=line(p1,q1,p2);
        float val2=line(p1,q1,q2);
        
        float val11=line(p2,q2,p1);
        float val12=line(p2,q2,q1);
        
        if(val1*val2<=0 && val11*val12<=0){
            return "true";
        }
        
        return "false";
    }
}