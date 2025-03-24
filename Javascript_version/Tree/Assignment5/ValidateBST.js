/**
 * 98. https://leetcode.com/problems/validate-binary-search-tree/description/
 * 
 * BST's property: the root key must be greater than the max of its left child key
 * and smaller than the min of its right child key.
 * 
 * Time: O(N) - Visit each ndoe exactly once
 * Space: O(H) - O(logN) for balanced tree
 */

var isValidBST = function(root) {
    return isBST(root, null, null);
};

var isBST = function(node, min, max) {
    // Base case - reaching the leaf node
    if(node == null) return true;
    /* the root key must be greater the min of its right child key
       and smaller than the max of its left child key */
    if(min != null && node.val <= min) return false;
    if(max != null && node.val >= max) return false;

    return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
};