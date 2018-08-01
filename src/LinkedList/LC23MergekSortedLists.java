package LinkedList;

import java.util.PriorityQueue;




public class LC23MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode toAdd = minHeap.poll();
            cur.next = toAdd;
            cur = toAdd;
            if (toAdd.next != null) minHeap.offer(toAdd.next);
        }
        return dummy.next;
    }



    //Solution 2
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);

    }

    private ListNode partition(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left < right - 1) {
            int mid = (right - left) / 2 + left;
            ListNode l1 = partition(lists, left, mid);
            ListNode l2 = partition(lists, mid + 1, right);
            return merge(l1, l2);
        }
        else return merge(lists[left], lists[right]);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return (l1 == null) ? l2 : l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        //IMPORTANT: post processing for list with different length
        cur.next = (cur1 != null) ? cur1 : cur2;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
