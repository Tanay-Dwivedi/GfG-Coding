//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.pairsViolatingBST(n, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int pairsViolatingBST(int n, Node root) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        inorder(root,al);
        int[] arr=new int[al.size()];
        int i=0;
        for(int x:al){
            arr[i]=x;
            i++;
        }
        return countinversion(arr,n);
       
        
    }
    static int countinversion(int[] arr,int n){
        return (int)mergesort(0,n-1,arr);
    }
    static long mergesort(int i,int j,int[] arr){
        long inversion=0;
        if(i<j){
            int mid=i+(j-i)/2;
            inversion+=mergesort(i,mid,arr);
            inversion+=mergesort(mid+1,j,arr);
            inversion+=merge(arr,i,mid,j);
        }
        return inversion;
    }
    static long merge(int[] arr,int s,int mid,int e){
        long[] temp = new long[e - s + 1];
        int i = s;
        int j = mid + 1;
        int k = 0;
        long inversion = 0;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inversion += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (int l = s; l <= e; l++) {
            arr[l] = (int) temp[l - s];
        }

        return inversion;
    }
    static void inorder(Node root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        inorder(root.left,al);
        al.add(root.data);
        inorder(root.right,al);
    }
}