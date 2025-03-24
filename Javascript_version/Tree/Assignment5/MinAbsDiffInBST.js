/**
 * 530. https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 * 
 * Using BST's inorder traversal to get the sorted array of the tree and compare adjacent elements.
 * BST's in-order traversal will visit the nodes in ascending order.
 * 
 * Time: O(N) - Each node is visited exactly once.
 * Space: O(H) - O(logN) for balanced tree, O(N) for skewed tree.
 */

var getMinimumDifference = function(root) {
    let minAbsDiff = Number.MAX_SAFE_INTEGER; // Initialize minAbsDiff to the maximum possible integer value
    let prevVal = null;
    traverse(root);

    return minAbsDiff;
    
    function traverse(node) {
        if(node == null) return;
        traverse(node.left);

        // Compute the absolute difference at the in-order position
        if(prevVal != null) {
            minAbsDiff = Math.min(minAbsDiff, node.val - prevVal);
        }

        prevVal = node.val;
        traverse(node.right);
    }
};