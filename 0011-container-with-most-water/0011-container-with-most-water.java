class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len == 2) {
          return Math.min(height[0], height[1]);
        }

        int maxVolume = 0;
        
        int left = 0, right = len - 1;
        while(left < right) {
          int curVolume = 0;
          if(height[left] >= height[right]) {
            curVolume = height[right] * (right - left);
            right--;
          } else {
            curVolume = height[left] * (right - left);
            left++;
          }
          maxVolume = Math.max(maxVolume, curVolume);
        }

        return maxVolume;
    }
}