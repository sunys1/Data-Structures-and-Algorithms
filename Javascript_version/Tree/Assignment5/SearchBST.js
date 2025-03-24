/**
 * 700. https://leetcode.com/problems/delete-node-in-a-bst/description/
 * 
 * BST has the property that for each node, all nodes in the left subtree are less than the node,
 * and all nodes in the right subtree are greater than the node.
 * 
 * Time: O(H) - H is the height of the tree. O(logN) for balanced tree, O(N) for skewed tree.
 * Space: O(H) - O(logN) for balanced tree, O(N) for skewed tree.
 */

var searchBST = function(root, val) {
    // Base case
    if(root == null || root.val == val) return root;

    if(root.val > val) {
        return searchBST(root.left, val);
    } else {
        return searchBST(root.right, val);
    }
};