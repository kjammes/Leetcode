class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> curAccounts = accounts.get(i);
            for (int idx = 1; idx < curAccounts.size(); idx++) {
                String mail = curAccounts.get(idx);
                if (map.containsKey(mail)) 
                    uf.merge(i, map.get(mail));
                else 
                    map.put(mail, i);
            }
        }
        
        List<String>[] merged = new List[n];
        for (int i = 0; i < n; i++) 
            merged[i] = new ArrayList<>();
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            String mail = pair.getKey();
            int idx = uf.find(pair.getValue());
            merged[idx].add(mail);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> el = merged[i];
            if (el.size() == 0)
                continue;
            Collections.sort(el);
            List<String> tem = new ArrayList<>();
            tem.add(accounts.get(i).get(0));
            for (String id: el)
                tem.add(id);
            res.add(tem);
        }
        
        return res;
    }
}


class UnionFind {
    int[] rank;
    int[] parent;
    
    UnionFind(int n) {
        this.rank = new int[n];
        this.parent = new int[n];
        for (int  i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }
    
    void merge(int x, int y) {
        int upX = find(x), upY = find(y);
        if (rank[upX] > rank[upY])
            parent[upY] = upX;
        else if (rank[upY] > rank[upX])
            parent[upX] = upY;
        else {
            parent[upX] = upY;
            rank[upY]++;
        }
    }
}