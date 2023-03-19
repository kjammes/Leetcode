class WordDictionary {
    
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        root.add(word, root);
    }
    
    public boolean search(String word) {
        return root.search(word, root);
    }
}

class Trie {
    Trie[] elements = new Trie[26];
    boolean isCompleteWord = false;
    
    public void add(String s, Trie node) {
        Trie curNode = node;
        for (char c: s.toCharArray()) {
            if (curNode.elements[c - 'a'] == null)
                curNode.elements[c - 'a'] = new Trie();
            curNode = curNode.elements[c - 'a'];
        }
        curNode.isCompleteWord = true;
    }
    
    public boolean search(String word, Trie curr) {
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.') {
                for(Trie ch: curr.elements)
                    if(ch != null && ch.search( word.substring(i+1), ch) ) return true;
                return false;
            }
            if(curr.elements[c - 'a'] == null) return false;
            curr = curr.elements[c - 'a'];
        }
        return curr != null && curr.isCompleteWord;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */