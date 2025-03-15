import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * Pre-order: root -> left -> right
 *
 * Push root node onto the stack to process first.
 * Then push children onto the stack in reverse order to process left children,
 * then right children.
 */

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<Node> st = new Stack<>();
        Node node = root;
        st.push(node);

        while(!st.isEmpty()){
            // Process node
            node = st.pop();
            res.add(node.val);
            // Push children onto the stack in reverse order
            for(int i = node.children.size() - 1; i >= 0; i--){
                st.push(node.children.get(i));
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
    };
}
