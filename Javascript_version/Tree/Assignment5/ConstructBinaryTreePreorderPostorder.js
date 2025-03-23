/**
 * 889. https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */

/*
Core idea: Either preorder + inorder or postorder + inorder can build a unique binary tree.
           Preorder + postorder could return multiple trees. 
           Why? Because if we assume the 2nd element in preorder is the root of the left subtree, it actually 
           could be the root of the right subtree if the left subtree is null, we can't tell for sure.

           We can use the 2nd element in preorder as the root of the left subtree, and find this 
           element in postorder, which gives us the boundary of the left subtree. Then we can recursively build the left subtree
           and right subtree.
*/
var constructFromPrePost = function(preorder, postorder) {
    // To save time, we can use a map to store the index of each element in inorder array
    let map = new Map();

    for (let i = 0; i < postorder.length; i++) {
        map.set(postorder[i], i);
    }

    // Build the tree recursively
    return helper(preorder, 0, preorder.length - 1,
                  postorder, 0, postorder.length - 1);
    // Use [preStart, preEend], [poStart, poEnd] intervals to track the subtrees
    function helper(preorder, preStart, preEnd, 
                    postorder, poStart, poEnd) {
        // Base case
        if (preStart > preEnd) return null;
        // Handle the case when the tree has only one node
        // Q105 and 106 don't need this because they don't need to access an extra element
        // for left subtree root node
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);

        // Root is the first element in preorder
        let rootVal = preorder[preStart];
        let root = new TreeNode(rootVal);
        // Find the left/right subtree root node index in postorder to get the left/right subtree size
        let leftRootIdx = map.get(preorder[preStart + 1]);
        // Calculate the left/right subtree size
        let leftLen = leftRootIdx - poStart + 1;

        // Build left subtree
        root.left = helper(preorder, preStart + 1, preStart + leftLen,
                        postorder, poStart, leftRootIdx);

        // Build right subtree
        root.right = helper(preorder, preStart + leftLen + 1, preEnd,
                            postorder, leftRootIdx + 1, poEnd - 1);

        return root;
    };
};