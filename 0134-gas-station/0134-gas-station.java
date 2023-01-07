class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        int totalGas = 0, totalCost = 0;
        
        for(int i = 0; i < len; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if (totalCost > totalGas) return -1;
        
        int curFuel = 0, start = 0;
        for(int i = 0; i < len; i++) {
            curFuel -= cost[i] - gas[i];
            if ( curFuel < 0 ) {
                start = i + 1;
                curFuel = 0;
            }
        }
        return start;
    }
}