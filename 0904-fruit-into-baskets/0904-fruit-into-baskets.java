class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> counter = new HashMap<>();
        int left = 0, res = 0, total = 0;
        
        for (int r = 0; r < fruits.length; r++) {
            counter.put(fruits[r], counter.getOrDefault(fruits[r], 0) + 1);
            total++;
            
            while (counter.size() > 2) {
                int fruit = fruits[left];
                counter.put(fruit, counter.get(fruit) - 1);
                total--;
                left++;
                
                if (counter.get(fruit) == 0)
                    counter.remove(fruit);
            }
            
            res = Math.max(res, total);
        }
        
        return res;
    }
}