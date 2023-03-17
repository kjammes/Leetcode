class Trie {

    Node node;

    public Trie() {
        node = new Node();
    }
    
    public void insert(String word) {
        Node temp = node;
        for (char c: word.toCharArray()) {
            if (!temp.containsKey(c))
                temp.put(c, new Node());
            temp = temp.get(c);
        }
        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = node;
        for (char c: word.toCharArray()) {
            if (!temp.containsKey(c))
                return false;
            temp = temp.get(c);
        }
        return temp.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node temp = node;
        for (char c: prefix.toCharArray()) {
            if (!temp.containsKey(c))
                return false;
            temp = temp.get(c);
        }
        return true;
    }
}

class Node {

    Node[] links = new Node[26];
    boolean isWordComplete = false;

    public void put(char c,Node node){
        links[c-'a']=node;
    }
    public Node get(char c){
        return links[c-'a'];
    }
    public boolean isEnd(){
        return isWordComplete;
    }
    public void setEnd(){
        isWordComplete = true;
    }
    public boolean containsKey(char c){
        return links[c-'a']!=null;
    } 
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */