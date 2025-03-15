import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * Apart from the recursion approach, using iterative stack is a common solution.
 *
 * In-order: left - root - right

 * Following the in-order, push root onto the stack and loop through
 * its left substree nodes, then pop the root and push its right subtree
 * nodes onto the stack. At the end, the nodes are traversed in-order.
 */

public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)  return res; // root can be null

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while(node != null || !st.isEmpty()){
            // keep looping the left substree until the leftmost leaf node
            while(node != null){
                st.push(node);
                node = node.left;
            }
            // reached null - process node - check right
            node = st.pop();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }
}
