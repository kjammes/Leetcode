class ProductOfNumbers {
    
    List<Integer> list;
    int lastProduct;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        lastProduct = 1;
    }
    
    public void add(int num) {
        if(num == 0) {
            list.clear();
            lastProduct = 1;
            return;
        }
        
        lastProduct *= num;
        list.add(lastProduct);
    }
    
    public int getProduct(int k) {
        int ind = list.size() - k;
        if(ind > 0) 
            return lastProduct / list.get(ind - 1);
        if(ind == 0)
            return lastProduct;
        
        return 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */