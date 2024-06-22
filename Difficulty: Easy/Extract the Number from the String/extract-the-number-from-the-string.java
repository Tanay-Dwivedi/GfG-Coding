//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends

class Solution {
    long ExtractNumber(String sentence) {
        ArrayList<Long> numberList = new ArrayList<>();
        String[] words = sentence.split(" ", 0);
        for (int i = 0; i < words.length; i++) {
            if (Character.isDigit(words[i].charAt(0)) && isValidNumber(words[i])) {
                numberList.add(Long.parseLong(words[i]));
            }
        }
        Collections.sort(numberList);
        if (numberList.size() != 0) {
            return numberList.get(numberList.size() - 1);
        }
        return -1;
    }

    boolean isValidNumber(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i)) || word.charAt(i) == '9') {
                return false;
            }
        }
        return true;
    }
}