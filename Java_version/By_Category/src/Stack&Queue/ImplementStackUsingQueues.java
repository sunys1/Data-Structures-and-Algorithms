/**
 * 225. https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * Time: O(N)
 * Space: O(N)
 *
 * Implement a stack using two queues.
 */

class MyStack {
    Queue<Integer> dq;
    Queue<Integer> hq;
    public MyStack() {
        dq = new LinkedList<>();
        hq = new LinkedList<>();
    }

    public void push(int x) {
        dq.offer(x);
    }

    public int pop() {
        while(dq.size() > 1) hq.offer(dq.poll());
        int polled = (int)dq.poll();
        swap();
        return polled;
    }

    /*
    Swap data queue and helper queue references to avoid
    repeatedly transfering data back and forth
    */
    public void swap(){
        Queue<Integer> temp = hq;
        hq = dq;
        dq = temp;
    }

    public int top() {
        while(dq.size() > 1) hq.offer(dq.poll());
        int polled = (int)dq.poll();
        swap();
        dq.offer(polled);
        return polled;
    }

    public boolean empty() {
        return dq.isEmpty() && hq.isEmpty();
    }
}

// 1-Queue Solution:
class MyStack {
    Queue<Integer> dq;
    int top_elem = 0;

    public MyStack() {
        dq = new LinkedList<>();
    }

    public void push(int x) {
        dq.offer(x);
        top_elem = x;
    }

    public int pop() {
        for(int i = 0; i < dq.size() - 2; i++){
            dq.offer(dq.poll());
        }
        // Keep track of new top element
        top_elem = dq.peek();
        dq.offer(dq.poll());

        return dq.poll();
    }

    public int top() {
        return top_elem;
    }

    public boolean empty() {
        return dq.isEmpty();
    }
}