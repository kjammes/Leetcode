class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] arr = new int[1000001];
        int res = 0;
        for(int cost: costs) {
            arr[cost]++;
        }
        
        for(int i = 1; i < 100001; i++) {
            if(arr[i] != 0) {
                long amount = arr[i] * i;
                if (amount <= coins) {
                    coins -= amount;
                    res += arr[i];
                } else {
                    res += coins / i;
                    break;
                }
            }
        }
        
        return res;
    }
}