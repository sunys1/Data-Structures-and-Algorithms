package ca.dsa;
import java.util.LinkedList;

/***
 * 706. https://leetcode.com/problems/design-hashmap/description/
 *
 * Separate Chaining approach:
 * - Use an array of LinkedList as the underlying data structure.
 */
class MyHashMap {
    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] map;
    private static final int SIZE = 1000; // Set default size as a constant for readability

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int hash(int key){
        // convert key to a unique index
        return key % map.length;
    }
    public void put(int key, int value) {
        int index = hash(key);
        // if list doesn't exist, create a new LinkedList
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }

        // search for the key
        LinkedList<Node> list = map[index];
        for (Node node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        // if key doesn't exist, add new node
        list.add(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);

        if (map[index] == null) {
            return -1;
        }else{
            LinkedList<Node> list = map[index];
            for (Node node : list) {
                if (node.key == key) {
                    return node.value;
                }
            }
        }

        // key doesn't exist in the list
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> list = map[index];

        if (list == null) {
            return;
        }

        list.removeIf(node -> node.key == key);
    }
}