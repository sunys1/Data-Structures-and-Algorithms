/**
 * 226. https://leetcode.com/problems/invert-binary-tree/
 */

// Level Order Traversal
var invertTree = function(root) {
    if (root == null) return root;
    q = [];
    q.push(root);

    while(q.length > 0){
        let node = q.pop();
        // swap left and right subtree
        let temp = node.left;
        node.left = node.right;
        node.right = temp

        if(node.left) q.push(node.left);
        if(node.right) q.push(node.right);
    }

    return root;
};

// Recursive Preorder
var invertTree = function(root) {
    if (root == null) return root;
    let temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
};

// Recursive Postorder
var invertTree = function(root) {
    if (root == null) return root;
    invertTree(root.left);
    invertTree(root.right);

    let temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
};

// Recursive Inorder
var invertTree = function(root) {
    if (root == null) return root;

    // here the left subtree is inverted
    invertTree(root.left);

    // here the inverted left subtree is swapped with right subtree, 
    // so the right subtree is inverted
    let temp = root.left;
    root.left = root.right;
    root.right = temp;

    // the new right subtree is already inverted, 
    // we only need to invert left subtree
    invertTree(root.left);

    return root;
}