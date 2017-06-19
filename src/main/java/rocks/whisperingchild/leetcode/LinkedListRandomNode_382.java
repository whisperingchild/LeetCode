package rocks.whisperingchild.leetcode;

import rocks.whisperingchild.leetcode.primitive.ListNode;

import java.util.Random;

/**
 * Created by WhisperingChild on 19/06/2017.
 */
public class LinkedListRandomNode_382 {
    private ListNode head;
    private Random random = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode_382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = -1;
        int i = 0;
        ListNode node = head;
        while (node != null) {
            ++i;
            float p = 1.0f/i;
            if (random.nextFloat() < p) {
                result = node.val;
            }
            node = node.next;
        }
        return result;
    }
}
