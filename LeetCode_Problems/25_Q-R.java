/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes to reverse
        ListNode node = head;
        for (int i = 0; i < k; ++i) {
            if (node == null) return head;
            node = node.next;
        }
        // Reverse k nodes
        ListNode prev = null, curr = head, next = null;
        for (int i = 0; i < k; ++i) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // Recursively call for the next part of the list
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
