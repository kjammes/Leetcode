class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        if(len < 3) 
            return 0;
        
        int left = 0, right = len - 1;
        int highestLeft = 0, highestRight = 0;

        int result = 0;
        while(left < right) {
          if(height[left] < height[right]) {
            if(height[left] >= highestLeft) 
              highestLeft = height[left];
            else
              result += highestLeft - height[left];
            left++;
          } else {
            if(height[right] >= highestRight)
              highestRight = height[right];
            else
              result += highestRight - height[right];
            right--;
          }
        }

        return result;
    }
}