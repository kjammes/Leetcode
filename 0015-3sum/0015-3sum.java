class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int res = nums[i] + nums[left] + nums[right];
                    if (res == 0) {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (res > 0) 
                        right--;
                    else
                        left++;
                }
            }
        }
        
        return result;
    }
}