class LRUCache {
    
    Map<Integer, Node> map;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        
        left = new Node(0, 0);
        right = new Node(0, 0);
        
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);
        
        if (map.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
    
    void insert(Node node) {
        Node prev = right.prev;
        Node next = right;
        
        prev.next = node;
        node.prev = prev;
        
        node.next = next;
        next.prev = node;
    }
    
    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
}

class Node {
    
    int key;
    int val;
    Node prev;
    Node next;
    
    Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */