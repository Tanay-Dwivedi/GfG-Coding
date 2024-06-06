//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends

class Solution {
    long max_sum(int a[], int n) {
        // Your code here
               long totalSum = 0;
        for (int value : a) {
            totalSum += (long)value;
        }
        
        // Calculate the initial value of i * a[i]
        long currentValue = 0;
        for (int i = 0; i < n; i++) {
            currentValue += (long)i * a[i];
        }
        
        // Initialize maximum sum with the initial value
       long maxValue = currentValue;
        
        // Iterate through the aay for each rotation
        for (int i = 1; i < n; i++) {
            // Calculate the next rotation sum using the previous rotation sum
            currentValue = (long) currentValue + totalSum - n *(long) a[n - i];
            // Update the maximum value
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }
        
        return maxValue;
    }
    }