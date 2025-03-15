/**
 * 155. https://leetcode.com/problems/min-stack/description/
 *
 * Use an extra minStack to keep track of current smallest element
 */

class MinStack {
    // Register all elements
    Stack<Integer> st;
    // Register current smallest element
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        // maintain minStack top element as the smallest element
        if(minSt.isEmpty() || minSt.peek() >= val){
            minSt.push(val);
        }
    }

    public void pop() {
        if(minSt.peek().equals(st.peek())){
            minSt.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}

/*
    Solution using linked list re-connection feature
    - Use much less extra space
    - Significantly faster by using Linked List O(1) operations
 */
class MinStack {
    private static class Node {
        int val;
        Node next;
        int min;

        public Node(int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    Node head;

    public MinStack() {
        // Use dummy node
        head = new Node(0, null, Integer.MAX_VALUE)
    }

    public void push(int val) {
        head = new Node(val, head, Math.min(val, head.min))
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min
    }
}