package rocks.whisperingchild.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whisperingchild on 16/06/2017.
 */
public class Permutations_46 {
    public List<List<Integer>> insert(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            result = insert(num, result);
        }
        return result;
    }
    private List<List<Integer>> insert(int num, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            int N = list.size();
            for (int i = 0; i <= N; ++i) {
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
