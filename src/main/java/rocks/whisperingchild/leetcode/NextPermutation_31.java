package rocks.whisperingchild.leetcode;

/**
 * Created by yiming on 15/06/2017.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) break;
        }
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
        }
        else {
            int smallBig = i + 1;
            for (int j = i+2; j < nums.length; ++j) {
                // Notice that it is <= instead of <, because there might be duplicated numbers.
                if (nums[j] > nums[i] && nums[j] <= nums[smallBig]) smallBig = j;
            }
            int temp = nums[i];
            nums[i] = nums[smallBig];
            nums[smallBig] = temp;
            reverse(nums, i+1, nums.length - 1);
        }
    }
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
