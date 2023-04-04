class Solution {
    public int partitionString(String s) {
        if (s.length() == 0)
            return 0;
        
        boolean[] used = new boolean[26];
        int partitions = 1;
        for (char c: s.toCharArray()) {
            int position = c - 'a';
            if (used[position]) {
                partitions++;
                used = new boolean[26];
                used[position] = true;
            }
            used[position] = true;
        }
        
        return partitions;
    }
}