class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length of the list
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Make it a circular list
        curr.next = head;

        // Step 3: Find the new head (length - k % length) steps ahead
        int stepsToNewHead = length - (k % length);
        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break the circle and return new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
