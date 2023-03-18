class BrowserHistory {
    
    List<String> list;
    int cur = 0;
    int total = 0;

    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        cur++;
        total++;
    }
    
    public void visit(String url) {
        if ( cur < list.size() ) {
            list.set(cur, url);
        } else {
            list.add(url);
        }
        cur++;
        total = cur;
    }
    
    public String back(int steps) {
        cur = Math.max(1, cur - steps);
        return list.get(cur - 1);
    }
    
    public String forward(int steps) {
        cur = Math.min(total, cur + steps);
        return list.get(cur - 1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */