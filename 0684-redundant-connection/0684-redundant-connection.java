class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (uf.find(x) == uf.find(y))
                return edge;
            uf.merge(x, y);
        }

        return new int[0];
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        this.parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            this.parent[i] = i;
        }
        this.rank = new int[n + 1];
    }

    int find(int x) {
        if (x == parent[x])
            return x;
        int xParent = find(parent[x]);
        parent[x] = xParent;
        return xParent;
    }

    void merge(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}



























