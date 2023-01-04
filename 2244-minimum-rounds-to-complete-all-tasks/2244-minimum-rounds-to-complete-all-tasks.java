class Solution {
    public int minimumRounds(int[] tasks) {
        if(tasks.length <= 1)
            return -1;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        
        int result = 0;
        for (int count : map.values()) {
            if (count == 1) return -1;

            result += count / 3;

            if(count % 3 != 0) result++;
        }
        
        return result;
    }
}