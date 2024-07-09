//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends

class Solution {
    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);
        int r=array[0]+array[1]+array[2];
        for(int i=0;i<array.length-2;i++)
        {
            int l=i+1;
            int h=array.length-1;
            while(l<h)
            {
                int s=array[i]+array[l]+array[h];
                if(Math.abs(target-s)<Math.abs(target-r))
                  r=s;
                else if(Math.abs(s-target)==Math.abs(r-target)&& s>r)
                   r=s;
               if(s==target)
                  return s;
                else if(s>target)
                 h--;
                else
                 l++;
            }
        }
        return r;
    }
}