class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        
        // Swap values of the two misplaced nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Inorder traversal: left -> node -> right
        inorder(node.left);

        // Find the first and second misplaced nodes
        if (prev != null && node.val < prev.val) {
            if (first == null) {
                first = prev;  // First misplaced node
            }
            second = node;  // Last misplaced node
        }
        prev = node;

        inorder(node.right);
    }
}
