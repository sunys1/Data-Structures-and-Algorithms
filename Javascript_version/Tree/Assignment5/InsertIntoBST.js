/**
 * 701. https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 * 
 * Using BST's property, compare the value of the root node with the value to be inserted
 * and recursively insert the value into the left or right subtree.
 * 
 * Time: O(H) - H is the height of the tree. O(logN) for balanced tree, O(N) for skewed tree.
 * Space: O(H) - O(logN) for balanced tree, O(N) for skewed tree.
 */

var insertIntoBST = function(root, val) {
    // Base case
    if(root == null) return new TreeNode(val);

    if(root.val > val) {
        root.left = insertIntoBST(root.left, val);
    } else if(root.val < val) {
        root.right = insertIntoBST(root.right, val);
    }
    
    return root;
};