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
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#')
            return;
        
        char c = board[i][j];
        TrieNode nextNode = node.children[c - 'a'];
        
        if (nextNode == null)
            return;
        
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // Avoid duplicates
        }
        
        board[i][j] = '#'; // Mark the cell as visited
        
        dfs(board, i - 1, j, nextNode, result);
        dfs(board, i + 1, j, nextNode, result);
        dfs(board, i, j - 1, nextNode, result);
        dfs(board, i, j + 1, nextNode, result);
        
        board[i][j] = c; // Backtrack
    }
}
