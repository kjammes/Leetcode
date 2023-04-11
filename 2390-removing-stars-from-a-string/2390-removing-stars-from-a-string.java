class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (res.length() < 1 && c == '*')
                return "";
            if (c == '*')
                res.deleteCharAt(res.length() - 1);
            else
                res.append(c);
        }
        return res.toString();
    }
}