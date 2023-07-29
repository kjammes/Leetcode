class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int m = isConnected.length;
        List<Integer>[] graph = new List[m];
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                // if (graph[i] == null) graph[i] = new ArrayList<>();
                // if (graph[j] == null) graph[j] = new ArrayList<>();
                // graph[i].add(j);
                // graph[j].add(i);
                uf.union(i, j);
            }
        }
        
        boolean visited[] = new boolean[m];
        int res = 0;
        Set<Integer> pars = new HashSet<>();
        for (int i = 0; i < m; i++) {
            // if (visited[i])
            //     continue;
            // res++;
            // dfs(graph, i, visited);
            pars.add(uf.find(i));
        }
        return pars.size();
    }
    
    private void dfs(List<Integer>[] graph, int node,boolean[] visited) {
        if (visited[node])
            return;
        
        visited[node] = true;
        for (int n: graph[node]) {
            if (visited[n])
                continue;
            dfs(graph, n, visited);
        }
    }
}

class UnionFind {
    int[] rank;
    int[] parent;
    
    UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    void union(int m, int n) {
        int mPar = find(m), nPar = find(n);
        if (rank[mPar] > rank[nPar]) {
            parent[nPar] = mPar;
        } else if (rank[mPar] < rank[nPar]) {
            parent[mPar] = nPar;
        } else {
            parent[mPar] = nPar;
            rank[nPar]++;
        }
    }
    
    int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}