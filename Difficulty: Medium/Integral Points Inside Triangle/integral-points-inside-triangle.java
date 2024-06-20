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
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    long InternalCount(long p[], long q[], long r[]) {
       long x1=p[0],y1=p[1];
       long x2=q[0],y2=q[1];
       long x3=r[0],y3=r[1];
       long  area=Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
       
        long points=boundrycount(p,q)+boundrycount(q,r)+boundrycount(p,r)+3;
        return (area-points+2)/2;
    }
    public static long gcd(long a,long b)
    {
        if(b==0)
        return a;
        
        return gcd(b,a%b);
    }
    public static long boundrycount(long []p,long []q)
    {
        if(p[0]==q[0])
        return Math.abs(p[1]-q[1])-1;
        if(p[1]==q[1])
        return Math.abs(p[0]-q[0])-1;
        return gcd(Math.abs(p[0]-q[0]),Math.abs(p[1]-q[1]))-1;
    }
};