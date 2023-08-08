class Node {
    int r, c, val;
    Node(int r, int c, int val) {
        this.r = r;
        this.c = c;
        this.val = val;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int[][] dirs = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };
        
        int n = grid.length;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        pq.offer(new Node(0, 0, grid[0][0]));
        
        boolean[][] visited = new boolean[n][n];
        
        int res = 0;
        while (!pq.isEmpty()) {
            int row = pq.peek().r, col = pq.peek().c, val = pq.poll().val;
            
            if (visited[row][col])
                continue;
            visited[row][col] = true;
            
            res = Math.max(res, val);
            if (row == n - 1 && col == n - 1)
                break;
            
            for (int dir[]: dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    pq.offer(new Node(x, y, grid[x][y]));
                }
            }
        }
        
        return res;
    }
}