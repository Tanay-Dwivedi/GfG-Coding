//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends

class Solution {
    String binaryNextNumber(String s) {
      StringBuilder sb=  new StringBuilder("");
        char last='1';
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='0'){
                sb.append(last);
                last='0';
            }else if(last=='1'){
                sb.append('0');
                last='1';
            }else{
                sb.append('1');
             }
        }
        sb.append(last);
        int i=0;
        sb.reverse();
        
        while(i<s.length() && sb.charAt(i)=='0'){
            i++;
        }
        
        
        
        
        return sb.substring(i).toString();
    }
}