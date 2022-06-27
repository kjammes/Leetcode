class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char el: n.toCharArray()) {
            max = Math.max(max, el - '0');
        }
        return max;
    }
}