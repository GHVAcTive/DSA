class Solution {
    public ListNode partition(ListNode head, int x) {
        // Two dummy nodes for two partitions
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Connect partitions
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
