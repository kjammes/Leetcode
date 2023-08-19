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
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        final int MOD = 100000;
        
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));
        
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int val = top.val;
            int steps = top.steps;
                
            for (int el: arr) {
                int newVal = (val * el) % MOD;
                if (1 + steps < dist[newVal]) {
                    dist[newVal] = 1 + steps;
                    if (newVal == end)
                        return dist[newVal];
                    q.offer(new Pair(newVal, steps + 1));
                }
                
            }
        }
        
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}

class Pair {
    int val;
    int steps;
    
    Pair(int val, int steps) {
        this.val = val;
        this.steps = steps;
    }
}
