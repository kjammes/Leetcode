class Pair {
    int level;
    String word;
    
    Pair(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        int len = endWord.length();
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        words.remove(beginWord);
        while (!q.isEmpty()) {
            String curWord = q.peek().word;
            int curWLevel = q.poll().level;
            
            if (curWord.equals(endWord))
                return curWLevel;
            
            for (int idx = 0; idx < len; idx++) {
                char[] chars = curWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[idx] = c;
                    String newWord = new String(chars);
                    if (words.contains(newWord)) {
                        q.offer(new Pair(newWord, curWLevel + 1));
                        words.remove(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}