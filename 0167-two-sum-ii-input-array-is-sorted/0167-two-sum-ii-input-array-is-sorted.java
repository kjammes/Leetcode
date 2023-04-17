class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int leftNum = numbers[l];
            int rightNum = numbers[r];
            
            int sum = leftNum + rightNum;
            if (sum == target)
                return new int[] {l + 1, r + 1};
            if (sum > target) 
                r--;
            else
                l++;
        }
        
        return new int[] {0, 0};
    }
}