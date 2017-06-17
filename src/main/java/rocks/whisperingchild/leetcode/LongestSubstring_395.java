package rocks.whisperingchild.leetcode;

import java.util.Arrays;

/**
 * Created by whisperingchild on 17/06/2017.
 */
public class LongestSubstring_395 {
    public int longestSubstring(String s, int k) {
        return twoPointers(s, k);
    }

    /*
     * Solution from https://discuss.leetcode.com/topic/57372/java-divide-and-conquer-recursion-solution
     */
    private int divideAndConquer(String s, int k, int start, int end) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; ++i) {
            ++count[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (count[i] < k && count[i] > 0) {
                for (int j = start; j < end; ++j) {
                    if (s.charAt(j) - 'a' == i) {
                        int left = divideAndConquer(s, k, start, j);
                        int right = divideAndConquer(s, k, j + 1, end);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    /*
     * Solution from https://discuss.leetcode.com/topic/57596/java-strict-o-n-two-pointer-solution
     */
    private int twoPointers(String s, int k) {
        if (s.length() < k) return 0;
        int [] count = new int[26];
        int i, j;
        int unique, noLessThanK;
        int length = s.length();
        int result = 0;
        for (int h = 1; h <= 26; ++h) {
            i = j = unique = noLessThanK = 0;
            Arrays.fill(count, 0);
            while (j < length) {
                if (unique <= h) {
                    int index = s.charAt(j) - 'a';
                    if (count[index] == 0) ++unique;
                    ++count[index];
                    if (count[index] == k) ++noLessThanK;
                    ++j;
                }
                else {
                    int index = s.charAt(i) - 'a';
                    if (count[index] == k) --noLessThanK;
                    --count[index];
                    if (count[index] == 0) --unique;
                    ++i;
                }
                if (unique == h && unique == noLessThanK) result = Math.max(result, j - i);
            }
        }
        return result;
    }
}
