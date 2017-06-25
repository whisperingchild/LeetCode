package rocks.whisperingchild.leetcode;

import java.util.Arrays;

/**
 * Created by WhisperingChild on 25/06/2017.
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        Integer[] index = new Integer[nums.length];
        for (int k = 0; k < index.length; ++k) {
            index[k] = k;
        }
        Arrays.sort(index, (o1, o2) -> {return nums[o1] - nums[o2];});
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[index[i]] + nums[index[j]];
            if (sum == target)
            {
                result[0] = index[i];
                result[1] = index[j];
                break;
            }
            else if (sum < target) ++i;
            else --j;
        }
        return result;
    }
}
