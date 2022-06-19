class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        int left = 0, right = products.length - 1;
        Arrays.sort(products);
        
        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            
            while( (left <= right) && ( ( products[left].length() <= i ) || ( products[left].charAt(i) != c ) ) ) {
                left++;
            }
            
            while( (left <= right) && ( ( products[right].length() <= i ) || ( products[right].charAt(i) != c ) ) ) {
                right--;
            }
            
            int remain = right - left + 1;
            List<String> cur = new ArrayList<>();
            for(int j = 0; j < Math.min(3, remain); j++) {
                cur.add(products[left + j]);
            }
            res.add(cur);
        }
        
        return res;
    }
}