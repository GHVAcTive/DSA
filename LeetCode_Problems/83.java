class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            // If current and next values are same, skip the next node
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Otherwise, move forward
                current = current.next;
            }
        }

        return head;
    }
}
