package LinkedList;

public class LC234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);
        slow.next = null;
        while (newHead != null) {
            if (head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
