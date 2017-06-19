package rocks.whisperingchild.leetcode;

import org.junit.Test;
import rocks.whisperingchild.leetcode.primitive.ListNode;

/**
 * Created by WhisperingChild on 15/06/2017.
 */
public class SampleTest {
    @Test
    public void permutationTest() {
        NextPermutation_31 s = new NextPermutation_31();
        int[] nums = {1,4,5,2,7,1,9};
        s.nextPermutation(nums);
    }

    @Test
    public void linkedListRandomNode_382_Test() {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i < 10; ++i) {
            node.next = new ListNode(i);
            node = node.next;
        }
        LinkedListRandomNode_382 random = new LinkedListRandomNode_382(head);
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.getRandom());
        }
    }

    @Test
    public void guessNumberHigherOrLowerII_375_Test() {
        GuessNumberHigherOrLowerII_375 solution = new GuessNumberHigherOrLowerII_375();
        System.out.println(solution.getMoneyAmount(1));
        System.out.println(solution.getMoneyAmount(2));
        System.out.println(solution.getMoneyAmount(3));
        System.out.println(solution.getMoneyAmount(4));
        System.out.println(solution.getMoneyAmount(5));
        System.out.println(solution.getMoneyAmount(6));
        System.out.println(solution.getMoneyAmount(7));
    }
}
