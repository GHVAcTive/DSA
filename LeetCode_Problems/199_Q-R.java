import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Check if the root is null
        if (root == null) {
            return result;
        }

        // Create a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Level order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Iterate through the nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Add the last node of each level to the result list
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Add left child if exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child if exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }
}
