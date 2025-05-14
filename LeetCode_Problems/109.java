
// LeetCode Problem 109 - Convert Sorted List to Binary Search Tree
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }
    private TreeNode buildTree(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = buildTree(start, slow);
        node.right = buildTree(slow.next, end);
        return node;
    }
}
