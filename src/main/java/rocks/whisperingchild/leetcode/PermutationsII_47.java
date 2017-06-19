package rocks.whisperingchild.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WhisperingChild on 16/06/2017.
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num : nums) {
            result = insert(num, result);
        }
        return result;
    }

    private List<List<Integer>> insert (int num, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            int N = list.size();
            int lastOccurrence = -1;
            for (int i = 0; i < N; ++i) {
                if (list.get(i) == num) lastOccurrence = i;
            }
            for (int i = lastOccurrence + 1; i <= N; ++i) {
                while (i < N && list.get(i) == num) ++i;
                List<Integer> permutation = new ArrayList<>();
                for (int k = 0; k < i; ++k) {
                    permutation.add(list.get(k));
                }
                permutation.add(num);
                for (int k = i; k < N; ++k) {
                    permutation.add(list.get(k));
                }
                result.add(permutation);
            }
        }
        return result;
    }
}
