/**
 * 94. https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
// Non-Recursive
var inorderTraversal = function(root) {
    if(root == null) return [];

    var res = [];
    var stack = [];
    var curr = root;

    while(curr != null || stack.length > 0){
        while(curr != null){
            // keep looping left subtree as long as curr.left is not null
            stack.push(curr);
            curr = curr.left;
        }

        // reached null in left subtree; process root node
        curr = stack.pop();
        res.push(curr.val);
        // check right subtree
        curr = curr.right;
    }

    return res;
};

// Recursive
var inorderTraversal = function(root) {
    if (root == null) return [];

    var res = [];
    res = res.concat(inorderTraversal(root.left));
    res.push(root.val);
    res = res.concat(inorderTraversal(root.right));

    return res;
}