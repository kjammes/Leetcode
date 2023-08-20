class Solution {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        
        for (int[] stone : stones) {
            dsu.union(stone[0], ~stone[1]);
        }
        
        return stones.length - dsu.islands;
    }
}

class DSU {
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;
    
    public int find(int x) {
        if (f.putIfAbsent(x, x) == null) {
            islands++;
        }
        if (x != f.get(x)) {
            f.put(x, find(f.get(x)));
        }
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}
