package rocks.whisperingchild.leetcode;

/**
 * Created by WhisperingChild on 21/06/2017.
 */
public class RangeSumQueryMutable_307 {
    /*
     * Solution from https://discuss.leetcode.com/topic/31599/java-using-binary-indexed-tree-with-clear-explanation
     *
     * Using Binary Indexed Tree
     */
    private int[] bit;
    private int[] nums;
    public RangeSumQueryMutable_307(int[] nums) {
        this.nums = new int [nums.length];
        this.bit = new int [nums.length + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        int index = i + 1;
        while (index <= nums.length) {
            bit[index] += diff;
            index += (index & -index);
        }
        nums[i] = val;
    }

    private int getSum(int i) {
        int sum = 0;
        int index = i + 1;
        while (index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}
