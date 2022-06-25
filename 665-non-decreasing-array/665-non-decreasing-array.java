class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        
        if(len <= 2) 
            return true;
        
        int count = 0;
        for(int i = 0; i < len-1; i++) {
            if(nums[i] > nums[i+1]) {
                count++;
            
                if( (i - 1) < 0 || nums[i-1] <= nums[i + 1] )
                    nums[i] = nums[i + 1];
                else
                    nums[i + 1] = nums[i];
            }
            
            if(count > 1) return false;    
        } 
        
        return count <= 1;
    }
}