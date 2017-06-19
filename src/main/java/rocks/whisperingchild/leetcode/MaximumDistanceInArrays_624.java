package rocks.whisperingchild.leetcode;

import java.util.List;

/**
 * Created by WhisperingChild on 18/06/2017.
 */
public class MaximumDistanceInArrays_624 {
    public int maxDistance(List<List<Integer>> arrays) {
        return betterSolution(arrays);
    }

    /*
     * Solution from https://discuss.leetcode.com/topic/92859/java-solution-min-and-max
     */
    private int betterSolution(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isFirst = true;
        for (List<Integer> array : arrays) {
            if (isFirst) {
                min = array.get(0);
                max = array.get(array.size() - 1);
                isFirst = false;
            }
            else {
                int head = array.get(0);
                int tail = array.get(array.size()-1);
                result = Math.max(result, max - head);
                result = Math.max(result, tail - min);
                min = Math.min(head, min);
                max = Math.max(tail, max);
            }
        }
        return result;
    }

    private int myOriginalSolution(List<List<Integer>> arrays) {
        int min, secondMin;
        int max, secondMax;
        min = secondMin = Integer.MAX_VALUE;
        max = secondMax = Integer.MIN_VALUE;
        int minIndex, maxIndex;
        minIndex = maxIndex = -1;
        int i = -1;
        for(List<Integer> array : arrays) {
            ++i;
            int N = array.size() - 1;
            if (N < 0) continue;
            int number = array.get(0);
            if (number < min) {
                secondMin = min;
                min = number;
                minIndex = i;
            }
            else if (number < secondMin) {
                secondMin = number;
            }

            number = array.get(N);
            if (number > max) {
                secondMax = max;
                max = number;
                maxIndex = i;
            }
            else if (number > secondMax) {
                secondMax = number;
            }
        }

        if (maxIndex == minIndex) {
            return Math.max(secondMax - min, max - secondMin);
        }
        else {
            return max - min;
        }
    }
}
