class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int m = isConnected.length;
        UnionFind uf = new UnionFind(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                uf.union(i, j);
            }
        }
        
        boolean visited[] = new boolean[m];
        int res = 0;
        Set<Integer> pars = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int uPar = uf.find(i);
            if (!pars.contains(uPar))
                pars.add(uPar);
        }
        return pars.size();
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
        if (parent[x] != x) 
            parent[x] = find(parent[x]);
        return parent[x];
    }

}