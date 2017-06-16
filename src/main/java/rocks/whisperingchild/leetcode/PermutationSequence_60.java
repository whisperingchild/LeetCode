package rocks.whisperingchild.leetcode;

/**
 * Created by yiming on 16/06/2017.
 */
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        --k;
        boolean[] isChosen = new boolean[n];
        int count = 1;
        int i;
        for (i = 1; i < n; ++i) {
            count *= i;
        }
        StringBuilder builder = new StringBuilder();
        for (--i; i > 0; --i) {
            int index = k / count;
            builder.append(selectKth(index, isChosen));
            k = k % count;
            count /= i;
        }
        builder.append(selectKth(0, isChosen));
        return builder.toString();
    }

    private char selectKth(int k, boolean[] isChosen) {
        int n = 0;
        for (int i = 0; i < isChosen.length; ++i) {
            if(!isChosen[i]) {
                if (k==0) {
                    isChosen[i] = true;
                    return (char)('1' + i);
                }
                else --k;
            }
        }
        // shall never run this
        return '0';
    }
}
