/**
 * 102. https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
// Non-Recursive
var levelOrder = function(root) {
    if (root == null) return [];

    let res = [];
    let queue = [];
    queue.push(root);
    
    while (queue.length > 0) {
        let sz = queue.length;
        let level = [];

        for(let i = 0; i < sz; i++){
            let node = queue.shift();
            level.push(node.val);

            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }

        res.push(level);
    }

    return res;
};

// Recursive
var levelorderTraversal = function(root) {
    if (root == null) return [];

    var res = [];
    res = res.concat(inorderTraversal(root.left));
    res.push(root.val);
    res = res.concat(inorderTraversal(root.right));

    return res;
}