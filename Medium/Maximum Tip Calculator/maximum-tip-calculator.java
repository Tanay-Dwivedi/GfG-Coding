//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
          Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            orders[i] = new Order(arr[i], brr[i], Math.abs(arr[i] - brr[i]));
        }

        // Sort orders based on the absolute difference in descending order
        Arrays.sort(orders, (o1, o2) -> o2.diff - o1.diff);

        long totalTips = 0;
        int countA = 0, countB = 0;

        for (Order order : orders) {
            if ((order.aTip >= order.bTip && countA < x) || countB >= y) {
                totalTips += order.aTip;
                countA++;
            } else {
                totalTips += order.bTip;
                countB++;
            }
        }

        return totalTips;
    }}

     class Order {
        int aTip;
        int bTip;
        int diff;

        Order(int aTip, int bTip, int diff) {
            this.aTip = aTip;
            this.bTip = bTip;
            this.diff = diff;
        }
    }