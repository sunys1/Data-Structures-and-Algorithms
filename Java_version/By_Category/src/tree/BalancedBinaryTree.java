/**
 * 110. https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Since we need to traverse each node and compare the height
 * of the left and right subtrees, we can use recursion and compare the heights
 * at the post-order position using a helper function.
 */

class Solution {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return isBalanced;
    }
    public int height(TreeNode root) {
        // Base case
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // compare the heights
        if(Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}