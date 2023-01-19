class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<>();
        
        sums.put(0, 1);
        
        int sum = 0, count = 0;
        for (int el: nums) {
            sum += el;
            int rem = sum % k;
            
            if (rem < 0)
                rem += k;
            
            if (sums.containsKey(rem)) {
                int countOfRem = sums.get(rem);
                count += countOfRem;
                sums.put(rem, countOfRem + 1);
            } else {
                sums.put(rem, 1);
            }
            
        }
        
        return count;
    }
}