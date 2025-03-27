/**
 * 146. https://leetcode.com/problems/lru-cache/description/
 *
 * get and put must each run in O(1) average time complexity.
 * We can use Linked HashMap to implement,
 * or use a doubly linked list with a hashmap to store key and node.
 * Use list head as least recently used, and list tail as the most recently used.
 * Use dummy node head and tail for easy insertion and deletion handling.
 * This gives us O(1) for both get and put.
 */

class LRUCache {
    // Use doubly linked list with custom Node
    private class Node {
        int key, value;
        Node next, prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head, tail; // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // if key exists, return node with key
        if (this.cache.containsKey(key)) {
            // update most recent access
            updateRecentAccess(key);
            return this.cache.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        // if key exists, update value
        if(this.cache.containsKey(key)) {
            this.cache.get(key).value = value;
            // update most recent access
            updateRecentAccess(key);
            return;
        }

        // if new key, check capacity
        if(this.cache.size() == this.capacity) {
            // delete oldest key - at list head
            Node oldest = this.head.next;
            this.cache.remove(oldest.key);
            this.head.next = oldest.next;
            oldest.next.prev = this.head;
            oldest.next = null;
            oldest.prev = null;
        }
        // insert new key node to the tail
        Node newNode = new Node(key, value);
        addToTail(newNode);
        this.cache.put(key, newNode);
    }

    public void addToTail(Node node) {
        node.next = this.tail;
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
    }

    public void updateRecentAccess(int key) {
        // delete key then insert to the tail
        Node keyToDelete = this.cache.get(key);
        keyToDelete.prev.next = keyToDelete.next;
        keyToDelete.next.prev = keyToDelete.prev;

        addToTail(keyToDelete);
    }
}