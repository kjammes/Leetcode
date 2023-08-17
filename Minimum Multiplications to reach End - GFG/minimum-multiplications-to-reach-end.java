//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int MOD_LIMIT = 100000;
    
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        int[] dist = new int[MOD_LIMIT];
        Arrays.fill(dist, (int) 10e8);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int num = node.num;
            int dis = node.dist;
            
            for (int el: arr) {
                int newNum = (num * el) % MOD_LIMIT;
                if (dis + 1 < dist[newNum]) {
                    dist[newNum] = dis + 1;
                    if (newNum == end)
                        return dis + 1;
                    q.offer(new Node(newNum, dis + 1));
                }
            }
        }
        
        return dist[end] == (int) 10e8 ? -1 : dist[end];
    }
}

class Node {
    int num;
    int dist;
    
    Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}
