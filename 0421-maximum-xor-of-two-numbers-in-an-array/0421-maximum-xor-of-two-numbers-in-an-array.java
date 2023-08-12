class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie tr = new Trie();
        for (int num: nums)
            tr.insert(num);
        
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            max = Math.max(max, tr.getMax(num));
        }
        
        return max;
    }
}

class Node {
    Node[] links;
    
    Node() {
        this.links = new Node[2];
    }
    
    boolean containsKey(int bit) {
        return links[bit] != null;
    }
    
    void put(int bit) {
        links[bit] = new Node();
    }
    
    Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    private Node root;
    
    Trie() {
        this.root = new Node();
    }
    
    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit))
                node.put(bit);    
            node = node.get(bit);
        }
    }
    
    public int getMax(int num) {
        Node node = root;
        int maxNum = 0; 
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else
                node = node.get(bit);
        }
        return maxNum;
    }
}

