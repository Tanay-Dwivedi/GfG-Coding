//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {

    // Method to compare two fractions
    String compareFrac(String str) {
        // Split the input string by comma and space to get the fractions
        String[] fractions = str.split(", ");

        // Split the first fraction to get numerator and denominator
        String[] fraction1 = fractions[0].split("/");
        double a = Double.parseDouble(fraction1[0]);
        double b = Double.parseDouble(fraction1[1]);

        // Split the second fraction to get numerator and denominator
        String[] fraction2 = fractions[1].split("/");
        double c = Double.parseDouble(fraction2[0]);
        double d = Double.parseDouble(fraction2[1]);

        // Calculate the decimal values of the fractions
        double res1 = a / b;
        double res2 = c / d;

        // Compare the fractions
        if (res1 == res2)
            return "equal";
        else if (res1 > res2)
            return fractions[0];  // Return the first fraction if it is greater
        else
            return fractions[1];  // Return the second fraction if it is greater
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.compareFrac("5/6, 11/45"));  // Output: 5/6
        System.out.println(sol.compareFrac("8/1, 8/1"));    // Output: equal
        System.out.println(sol.compareFrac("10/17, 9/10")); // Output: 9/10
    }
}