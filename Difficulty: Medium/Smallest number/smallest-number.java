//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution {
    public String smallestNumber(int s, int d) {
        int start = (int)Math.pow(10,d-1);
        int end = (int)Math.pow(10,d);
        
        for(int i=start;i<end;i++){
            int  sum = sumOfDigit(i);
            if(sum==s){
                return ""+i;
            }
        }
        return "-1";
    }
    
    int sumOfDigit(int num){
        int sum = 0;
        while(num>0){
            int remainder = num%10;
            sum+=remainder;
            num = num/10;
        }
        return sum;
    }
}