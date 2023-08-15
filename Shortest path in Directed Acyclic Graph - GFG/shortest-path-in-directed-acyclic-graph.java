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

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new Node(0, 0));
        res[0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node ng : graph[node.val]) {
                if (node.dist + ng.dist < res[ng.val]) {
                    res[ng.val] = node.dist + ng.dist;
                    pq.offer(new Node(ng.val, node.dist + ng.dist));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (res[i] == (int) 1e6)
                res[i] = -1;
        }

        return res;
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

