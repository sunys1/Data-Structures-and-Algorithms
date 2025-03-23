/**
 * 145.https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
// Non-Recursive
var postorderTraversal = function(root) {
    if(root == null) return [];

    var res = [];
    var stack = [root];

    while(stack.length > 0){
        var node = stack.pop();
        // add value to the beginning of the array to simulate the reverse order
        res.unshift(node.val);

        // push left and right subtree without reversing 
        // since we will be adding value to the front of the array
        if(node.left) stack.push(node.left);
        if(node.right) stack.push(node.right);
        
    }

    return res;
};

// Recursive
var postorderTraversal = function(root) {
    if(root == null) return [];
    var res = [];
    
    res = res.concat(postorderTraversal(root.left));
    res = res.concat(postorderTraversal(root.right));
    res.push(root.val);

    return res;
};