//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    public int findPeakElement(List<Integer> a) {
        int n=a.size();
		int left=0;
		int right=n-1;
		while(left<=right) {
			int mid=(left+right)>>1;
			int next=(mid+1)%n;
			int prev=(mid+n-1)%n;
			if(a.get(mid)>a.get(prev) && a.get(mid)>a.get(next))
				return a.get(mid);
		    else if((mid+1)<n && a.get(mid)>a.get(mid+1)) 
				right=mid-1;
			else 
				left=mid+1;
		}
		return -1;
    }
}