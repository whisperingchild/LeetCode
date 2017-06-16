package rocks.whisperingchild.leetcode;

import org.junit.Test;

/**
 * Created by yiming on 15/06/2017.
 */
public class SampleTest {
    @Test
    public void PermutationTest() {
        NextPermutation_31 s = new NextPermutation_31();
        int[] nums = {1,4,5,2,7,1,9};
        s.nextPermutation(nums);
    }
}
