class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }
        
        // If both p and q are greater than root, LCA is in the right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        // If both p and q are less than root, LCA is in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        // If root is between p and q, then root is the LCA
        return root;
    }
}
