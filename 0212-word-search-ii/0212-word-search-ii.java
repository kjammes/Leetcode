class TrieNode {
    TrieNode[] children;
    String word;
    
    TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTree(words);
        int m = board.length, n = board[0].length;
        
        List<String> result = new ArrayList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                dfs(root, r, c, result, board);
            }
        }
        
        return result;
    }
    
    private TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (char el: word.toCharArray()) {
                if (node.children[el - 'a'] == null)
                    node.children[el - 'a'] = new TrieNode();
                node = node.children[el - 'a'];
            }
            node.word = word;
        }
        return root;
    }
    
    private void dfs(TrieNode node, int r, int c, List<String> result, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#')
            return;
        
        char ch = board[r][c];
        TrieNode nextNode = node.children[ch - 'a'];
        if (nextNode == null)
            return;
        
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }
        
        board[r][c] = '#';
        
        dfs(nextNode, r + 1, c, result, board);
        dfs(nextNode, r - 1, c, result, board);
        dfs(nextNode, r, c + 1, result, board);
        dfs(nextNode, r, c - 1, result, board);
        
        board[r][c] = ch;
    }
}

















