class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (head != null) {
            // If it's the start of duplicates sequence
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;  // Skip entire duplicate group
            } else {
                prev = prev.next;  // Safe to move ahead
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}
