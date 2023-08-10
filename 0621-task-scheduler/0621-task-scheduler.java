class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char el: tasks) 
            freqs[el - 'A']++;
        
        Arrays.sort(freqs); // Sort frequencies in ascending order
        
        int maxFreq = freqs[25];
        int idleSlots = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && freqs[i] > 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, freqs[i]);
        }
        
        idleSlots = Math.max(0, idleSlots); // Idle slots can't be negative
        
        return tasks.length + idleSlots;
    }
}
