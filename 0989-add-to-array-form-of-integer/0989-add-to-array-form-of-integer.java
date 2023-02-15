class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int n = k % 10;
            k /= 10;
            int curNum = num[i] + n + carry;
            result.add(curNum % 10);
            carry = curNum / 10;
        }
        while (k != 0) {
            int n = k % 10;
            k /= 10;
            int curNum = n + carry;
            result.add(curNum % 10);
            carry = curNum / 10;
        }
        if (carry != 0)
            result.add(carry);
        Collections.reverse(result);
        return result;
    }
}