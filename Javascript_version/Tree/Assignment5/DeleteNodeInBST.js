/**
 * 450. https://leetcode.com/problems/delete-node-in-a-bst/description/
 * 
 * The deleteNode function takes a root node and a key, so intuitively we can check 3 cases:
 * 1. root.val == key
 * 2. root.val > key
 * 3. root.val < key
 * 
 * In case 1, we can handle deleting degree-1 and degree-0 nodes easily.
 * For degree-2 nodes, we can find the in-order successor using the getSuccessor function, 
 * replace the root node with successor node's value, and then recursively delete the successor.
 * 
 * In case 2 and 3, we can recursively search the left or right subtree to find the node with the key and delete.
 */

var deleteNode = function(root, key) {
    if(root == null) return root;
    // Compare root value with key
    if(root.val == key) {
        // Handle both 1-child and 0-child cases
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        // Handle 2-child case
        // Get successor
        let s = getSuccessor(root);
        root.val = s.val;

        // Remove successor: either degree-1 or degree-0
        root.right = deleteNode(root.right, s.val);
    }else if(root.val > key){
        root.left = deleteNode(root.left, key);
    }else if(root.val < key){
        root.right = deleteNode(root.right, key);
    }

    return root;
};

// Successor is the smallest node in the right subtree
var getSuccessor = function(node) {
    // 1. right != null
    let right = node.right;
    if(right != null){
        while(right.left) right = right.left;
        return right;
    }

    // 2. right == null && node.parent != null
    while(node.right == null && node == node.parent.right) {
        node = node.parent;
    }
    return node.parent;
};