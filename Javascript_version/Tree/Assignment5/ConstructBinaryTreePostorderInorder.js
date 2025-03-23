/**
 * 106. https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */

/*
Core idea: find the root node in inorder array, 
           then recursively build left and right subtree

Postorder traversal: left -> right -> root  => root is the last element
Inorder traversal: left -> root -> right => root is in the middle of the array, 
left part is left subtree, right part is right subtree

With this pattern in mind, for each root node, we can 
find the left and right subtree. Then we can recursively build the tree.
*/

var buildTree = function(inorder, postorder) {
    // To save time, we can use a map to store the index of each element in inorder array
    let map = new Map();

    for (let i = 0; i < inorder.length; i++) {
        map.set(inorder[i], i);
    }

    // Build the tree recursively
    return helper(postorder, 0, postorder.length - 1,
                  inorder, 0, inorder.length - 1);
    // Use [pStart, pEend], [iStart, iEnd] intervals to track the subtrees
    function helper(postorder, pStart, pEnd, 
                        inorder, iStart, iEnd) {
        // Base case
        if (pStart > pEnd) return null;

        // Root is the last element in postorder
        let rootVal = postorder[pEnd];
        // Find the root value in inorder and build the root node
        let rootIdx = map.get(rootVal);
        let root = new TreeNode(rootVal);
        // Calculate the left subtree size
        let leftLen = rootIdx - iStart;

        // Build left subtree
        root.left = helper(postorder, pStart, pStart + leftLen - 1,
                        inorder, iStart, rootIdx - 1);

        // Build right subtree
        root.right = helper(postorder, pStart + leftLen, pEnd - 1,
                            inorder, rootIdx + 1, iEnd);

        return root;
    };
};