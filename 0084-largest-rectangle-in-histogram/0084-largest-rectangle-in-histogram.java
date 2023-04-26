class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int start = 0;
        int res = 0;

        // { index, height }
        Stack<int[]> stack = new Stack();
        for (int idx = 0; idx < size; idx++) {
            start = idx;
            while (!stack.isEmpty() && stack.peek()[1] > heights[idx]) {
                int[] pair = stack.pop();
                int height = pair[1];
                int startIdx = pair[0];

                res = Math.max(res, height * (idx - startIdx));
                start = startIdx;
            }
            stack.push(new int[] {start, heights[idx]});
        }

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int height = pair[1];
            int startIdx = pair[0];

            res = Math.max(res, height * (size - startIdx));
        }

        return res;
    }
}