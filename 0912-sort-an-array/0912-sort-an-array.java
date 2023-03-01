class Solution {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (right - left < INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
        
        /**
        public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
        Parameters : 
        source_arr : array to be copied from
        sourcePos : starting position in source array from where to copy
        dest_arr : array to be copied in
        destPos : starting position in destination array, where to copy in
        len : total no. of components to be copied.
        **/
    }

    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= left && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
    }
}
