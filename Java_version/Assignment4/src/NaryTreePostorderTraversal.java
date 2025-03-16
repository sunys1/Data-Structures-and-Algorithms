import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 590. https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * Post-order: left - right - root
 */

/* Solution 1: single stack and arraylist

Following the post-order, push root onto the main stack and loop through
its left substree node, then right subtree nodes.
Use an extra stack stRoots to maintain the root nodes that need to be
processed after its children have been processed. If a root node is visited
for the first time, push onto both stacks. Othwerise, the root node
is the top node on the stRoots stack and its children have been
processed, so process the root node and pop it from both stacks.

This solution works correctly but not ideal. It uses extra space and time.
*/

public class NaryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<Node> st = new Stack<>();
        Stack<Node> stRoots = new Stack<>();
        Node node = root;
        st.push(node);

        while(!st.isEmpty()){
            // push children onto the stack in reverse order
            // to realize the left - right - root post-order
            node = st.peek();
            if(node.children.size() > 0){
                if(node == (stRoots.isEmpty() ? null : stRoots.peek())){
                    res.add(node.val);
                    st.pop();
                    stRoots.pop();
                }else{
                    stRoots.push(node);
                    for(int i = node.children.size() - 1; i >= 0; i--){
                        st.push(node.children.get(i));
                    }
                }
            }else{
                // Reached leftmost leaf - process node
                res.add(node.val);
                st.pop();
            }
        }

        return res;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

/*
Solution 2: single stack and linkedlist

- Use a doubly linkedlist to simulate the post-order by adding popped nodes to the front of the list.
  Takeaway: try to analyze the problem and use the appropriate data structure that gives the most
  convenience. ArrayList fits in-order and pre-order, but not necessarily post-order.

  Time: O(N) - each node visited exactly once
  Space: O(N)
*/
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // Add to the front to simulate reverse order
            res.addFirst(node.val);

            for (Node child : node.children) {
                // Push children without reversing
                stack.push(child);
            }
        }

        return res;
    }
}
