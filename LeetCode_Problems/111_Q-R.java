class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If the left subtree is null, recursively check right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        
        // If the right subtree is null, recursively check left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        
        // If both left and right subtrees exist, take the minimum depth
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
