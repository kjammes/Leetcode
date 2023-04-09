class Solution {
    Boolean[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if ( memo[i][j] != null )
            return memo[i][j];
        Boolean ans;
        
        if (j == pattern.length()) {
            ans = i == text.length();
            memo[i][j] = ans;
            return ans;
        }
            
        boolean match = (i < text.length()) &&
                        (
                            text.charAt(i) == pattern.charAt(j) ||
                            pattern.charAt(j) == '.'
                        );
        if (
            (j + 1) < pattern.length() &&
            pattern.charAt(j + 1) == '*'
        ) {
            ans = (
                    dp(i, j + 2, text, pattern) || 
                    (
                        match && dp(i + 1, j, text, pattern)
                    )
                  );
        } else
            ans = match && dp(i + 1, j + 1, text, pattern);
        
        memo[i][j] = ans;
        return ans;
    }
}