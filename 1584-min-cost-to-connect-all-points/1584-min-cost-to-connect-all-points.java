class Pair{
    int src;
    int dest;
    int cost;
    
    Pair(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        DSU dsu = new DSU(len);
        int cost = 0;

        List<Pair> edges=new ArrayList();
        for(int src_point=0;src_point<len;src_point++){
            
            for(int dest_point=src_point+1;dest_point<len;dest_point++)
            {
                int distance=Math.abs(points[src_point][0] - points[dest_point][0] ) + 
                    Math.abs(points[src_point][1] - points[dest_point][1] );
                
                edges.add(new Pair(src_point,dest_point,distance));
            }
        }
        
        Collections.sort(edges, (a, b) -> a.cost - b.cost);
        for (Pair edge: edges) {
            if (dsu.find(edge.src) ==  dsu.find(edge.dest))
                continue;
            cost += edge.cost;
            dsu.union(edge.src, edge.dest);
        }

        return cost;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }
    
    int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    void union(int x, int y) {
        int upX = find(x);
        int upY = find(y);
        if (rank[upX] > rank[upY]) {
            parent[upY] = upX;
        } else if (rank[upY] > rank[upX]) {
            parent[upX] = upY;
        } else {
            parent[upY] = upX;
            rank[upX]++;
        }
    }
}