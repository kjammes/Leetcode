class Solution {
    
    int[][] dirs = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}
    };
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        DSU  dsu = new DSU(n * n);
        List<Integer> positions = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                positions.add(i * n + j);
        Collections.sort(positions, (a, b) -> grid[a/n][a%n] - grid[b/n][b%n]);
        
        for (int pos: positions) {
            int r = pos / n, c = pos % n;
            
            for (int[] dir: dirs) {
                int nR = r + dir[0], nC = c + dir[1];
                
                if (nR >= 0 && nC >= 0 && nR < n && nC < n && grid[nR][nC] < grid[r][c])
                    dsu.union(pos, nR * n + nC);
            }
            
            if (dsu.find(0) == dsu.find(n * n - 1))
                return grid[r][c];
        }
        
        return -1;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) 
            parent[i] = i;
        rank = new int[n];
    }
    
    int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        
        if (rank[pX] > rank[pY]) {
            parent[pY] = pX;
        } else if (rank[pX] < rank[pY]) {
            parent[pX] = pY;
        } else {
            parent[pX] = pY;
            rank[pX]++;
        }
    }
}