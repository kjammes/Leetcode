class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : stoneNodes.entrySet()) {
            if (ds.findUPar(entry.getKey()) == entry.getKey()) {
                cnt++;
            }
        }

        return n - cnt;
    }
}

class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = findUPar(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int rootU = findUPar(u);
        int rootV = findUPar(v);

        if (rootU != rootV) {
            if (size[rootU] > size[rootV]) {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            } else {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            }
        }
    }
}
