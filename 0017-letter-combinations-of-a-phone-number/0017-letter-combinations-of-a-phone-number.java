class Solution {
    
    char[][] numMap = {
        {}, // 0
        {}, // 1
        {'a', 'b', 'c'}, // 2
        {'d', 'e', 'f'}, // 3
        {'g', 'h', 'i'}, // 4
        {'j', 'k', 'l'}, // 5
        {'m', 'n', 'o'}, // 6
        {'p', 'q', 'r', 's'}, // 7
        {'t', 'u', 'v'}, // 8
        {'w', 'x', 'y', 'z'}, // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        f(res, new StringBuilder(), digits, 0);
        return res;
    }
    
    private void f(List<String> res, StringBuilder cur, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(new String(cur));
            return;
        }
        
        char[] chars = numMap[digits.charAt(idx) - '0'];
        for (char el: chars) {
            cur.append(el);
            f(res, cur, digits, idx + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}