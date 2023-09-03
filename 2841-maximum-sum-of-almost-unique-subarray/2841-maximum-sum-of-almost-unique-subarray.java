class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int len = nums.size();
        long res = 0;
        long sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        int start = 0, end = 0;
        while (end < len) {
            while ((end - start + 1) <= k) {
                int curNum = nums.get(end);
                sum += curNum;
                int endFreq = freq.getOrDefault(curNum, 0) + 1;
                freq.put(curNum, endFreq);
                end++;
            }
            
            if (freq.size() >= m)  {
                res = Math.max(res, sum);
            }
            
            int startNum = nums.get(start++);
            sum -= startNum;
            int startFreq = freq.get(startNum);
            if (startFreq == 1)
                freq.remove(startNum);
            else
                freq.put(startNum, startFreq - 1);
        }
        
        return res;
    }
}