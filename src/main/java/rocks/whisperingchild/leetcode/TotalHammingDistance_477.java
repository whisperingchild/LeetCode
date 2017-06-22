package rocks.whisperingchild.leetcode;

/**
 * Created by WhisperingChild on 20/06/2017.
 */
public class TotalHammingDistance_477 {
    /*
     * Solution from https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
     */
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int N = nums.length;
        for (int i = 0; i < 32; ++i) {
            int count = 0;
            for (int j = N-1; j >= 0; --j) {
                count += (nums[j] >>> i) & 1;
            }
            result += count * (N - count);
        }
        return result;
    }
}
