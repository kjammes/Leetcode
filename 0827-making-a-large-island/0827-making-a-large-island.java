class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        
        DSU dsu = new DSU(n * n);
        
        int[][]  dirs = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;
                
                int num = row * n + col;
                for (int[] dir: dirs) {
                    int x = row + dir[0], y = col + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0)
                        continue;
                    int newNum = x * n + y;
                    dsu.merge(num, newNum);
                }
            }
        }
        
        int res = Integer.MIN_VALUE;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;
                
                // int num = row * n + col;
                Set<Integer> ultPars = new HashSet<>();
                for (int[] dir: dirs) {
                    int x = row + dir[0], y = col + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0)
                        continue;
                    int newNum = x * n + y;
                    ultPars.add(dsu.find(newNum));
                }
                
                int islandSize = 1;
                for (int el: ultPars) 
                    islandSize += dsu.size[el];
                
                res = Math.max(res, islandSize);
            }
        }
        
        for (int i = 0; i < n * n; i++)
            res = Math.max(res, dsu.size[i]);
        
        return res;
    }
}

class DSU {
    int[] size;
    int[] parent;
    
    DSU(int n) {
        this.size = new int[n];
        Arrays.fill(size, 1);
        this.parent=  new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }
    
    void merge(int x, int y) {
        int upX = find(x), upY = find(y);
        if (upX == upY)
            return;
        
        if (size[upX] > size[upY]) {
            size[upX] += size[upY];
            parent[upY] = upX;
        } else {
            size[upY] += size[upX];
            parent[upX] = upY;
        }
    }
}