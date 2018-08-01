package LinkedList;

import java.util.HashMap;

public class LC138CopyListwithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode dummy = new RandomListNode(head.label);
        RandomListNode cur = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>(); //old -> new map
        while (head != null) {
            RandomListNode next;
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.label));
            }
            next = map.get(head);
            if (head.random != null) {
                if(!map.containsKey(head.random)){
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                next.random = map.get(head.random);
            }
            cur.next = next;
            cur = next;
            head = head.next;
        }
        return dummy.next;
    }
    }
}
