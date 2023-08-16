//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<Pair>[] adj = new ArrayList[n + 1];
        int[] parent = new int[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = i;
            distance[i] = (int) 1e8;
        }
        
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Pair(1, 0));
        distance[1] = 0;
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            
            for (Pair ng : adj[p.node]) {
                if (ng.weight + p.weight < distance[ng.node]) {
                    distance[ng.node] = ng.weight + p.weight;
                    pq.offer(new Pair(ng.node, ng.weight + p.weight));
                    parent[ng.node] = p.node;
                }
            }
        }
        
        if (distance[n] == (int) 1e8)
            return Arrays.asList(-1);
            
        List<Integer> res = new ArrayList<>();
        res.add(n);
        findParent(n, res, parent);
        Collections.reverse(res);
        return res;
    }
    
    private void findParent(int node, List<Integer> res, int[] parent) {
        if (parent[node] == node) {
            return;
        }
        res.add(parent[node]);
        findParent(parent[node], res, parent);
    }
}

class Pair {
    int node;
    int weight;
    
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}