// Recursive
var preorderTraversal = function(root) {
    var res = []
    if(root == null){
        return res;
    }
    // process root
    res.push(root.val);
    // process left
    res = res.concat(preorderTraversal(root.left));
    res = res.concat(preorderTraversal(root.right));

    return res;
};

// Non-Recursive
var preorderTraversal = function(root) {
    if(root == null) return [];

    var res = [];
    var stack = [root];

    while(stack.length > 0){
        var node = stack.pop();
        res.push(node.val);
        
        // push right first so that left is processed first
        if(node.right) stack.push(node.right.val);
        if(node.left) stack.push(node.left.val);
    }

    return res;
}