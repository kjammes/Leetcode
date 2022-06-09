class Solution {
    public int[] twoSum(int[] n, int target) {
        int len = n.length;
        
        int left  = 0;
        int right = len - 1;
        
        while(left < right) {
            int sum = n[left] + n[right];
            if( sum == target )
                break;
            
            if( sum > target )
                right--;
            else
                left++;
        }
        
        return new int[] {left + 1, right + 1};
    }
}