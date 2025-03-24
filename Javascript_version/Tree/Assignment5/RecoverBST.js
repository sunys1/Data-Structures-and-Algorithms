/**
 * 99. https://leetcode.com/problems/recover-binary-search-tree/description/
 * 
 * Similar to Q530 (MinAbsDiffInBST.js), we can use in-order traversal to get the sorted array of the tree.
 * Then we can find the two nodes that are swapped by mistake by comparing adjacent elements recursively.
 * At the in-order position, we register the first and second nodes that are out of order.
 * 
 * Time: O(N) - Visit each node exactly once
 * Space: O(H) - O(logN) for balanced tree.
 */

var recoverTree = function(root) {
    let firstNode = null, secondNode = null;
    // MIN_VALUE is the smallest positive floating point number.
    // MIN_SAFE_INTEGER, instead, is the smallest integer. MIN_VALUE could cause error in this case.
    let prevNode = new TreeNode(Number.MIN_SAFE_INTEGER); 

    traverse(root);

    function traverse(node) {
        if (node == null) return;
        traverse(node.left);

        // Compare the adjacent elements at the in-order position
        if (node.val < prevNode.val) { 
            if (firstNode == null) {
                firstNode = prevNode; // First misplaced node
            }
            // if we have detected the first misplaced node, updated the second misplaced node
            secondNode = node; 
        }
        // Update prevNode for the next comparison
        prevNode = node; 
        traverse(node.right);
    }

    // Swap the two misplaced nodes
    let temp = firstNode.val;
    firstNode.val = secondNode.val;
    secondNode.val = temp;
};