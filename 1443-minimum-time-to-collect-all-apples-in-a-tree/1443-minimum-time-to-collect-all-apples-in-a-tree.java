class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        ArrayList<Integer>[] a = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<Integer>();
        }
        
        for(int[] x:edges){
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }

        return dfs(-1,0,a,hasApple);
    }
    
    private int dfs(int prev,int curr,ArrayList<Integer>[] a,List<Boolean> hasApple) {
        int res = 0;
        
        for(int node: a[curr]) {
            if (node != prev) {
                int dres = dfs(curr, node, a, hasApple);
                
                if (dres > 0 || hasApple.get(node))
                    res += (dres + 2);
            }
        }
        
        return res;
    }
}