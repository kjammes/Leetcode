//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {
        int[] res = new int[N];
        Arrays.fill(res, (int) 1e6);

        List<Node>[] graph = new List[N];
        for (int i = 0; i < N; i++) { graph[i] = new ArrayList<>(); }

        for (int i = 0; i < M; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new Node(edge[1], edge[2]));
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[N];
        topoSort(0, graph, vis, stack);
        
        res[0] = 0;
        while (!stack.empty()) {
            int node = stack.pop();
        
            for (Node ng : graph[node]) {
                if (ng.dist + res[node] < res[ng.val]) {
                    res[ng.val] = ng.dist + res[node]; 
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (res[i] == (int) 1e6)
                res[i] = -1;
        }

        return res;
    }
    
    private void topoSort(int node, List<Node>[] adj,
      boolean vis[], Stack < Integer > st) {
    
      vis[node] = true;
      for (Node ng: adj[node]) {
        int v = ng.val;
        if (!vis[v]) {
          topoSort(v, adj, vis, st);
        }
      }
      
      st.add(node);
    }

}

class Node {
    int val;
    int dist;

    Node(int val, int dist) {
        this.val = val;
        this.dist = dist;
    }
}

