//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static String oddEven(String s) {
       int []alpha=new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(alpha[i]==0) continue;
            if((i+1)%2==0 && alpha[i]%2==0){
                count++;
            }
            if((i+1)%2!=0 && alpha[i]%2!=0) count++;
        }
        return count%2==0?"EVEN":"ODD";
    }
}