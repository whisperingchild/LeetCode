package rocks.whisperingchild.leetcode;

/**
 * Created by WhisperingChild on 19/06/2017.
 */
public class GuessNumberHigherOrLowerII_375 {
    public int getMoneyAmount(int n) {
        return topDown(n);
    }

    private int topDown(int n) {
        int[][] dp = new int[n][n];
        return topDown(0, n-1, dp);
    }

    private int topDown(int start, int end, int[][] dp) {
        if (start >= end) return 0;
        int result = Integer.MAX_VALUE;
        if (dp[start][end] == 0) {
            for (int i = start; i <= end; ++i) {
                result = Math.min(result, i + 1 + Math.max(topDown(start, i-1, dp), topDown(i+1, end, dp)));
            }
            dp[start][end] = result;
        }
        return dp[start][end];
    }

    private int bottomUp(int n) {
        int [][] dp = new int[n][n];
        for (int length = 1; length < n; ++length) {
            for (int start = n - length - 1; start >= 0; --start) {
                int result = Integer.MAX_VALUE;
                int end = start + length;
                for (int j = start; j <= end; ++j) {
                    int left = j == start ? 0 : dp[start][j-1];
                    int right = j == end ? 0 : dp[j+1][end];
                    result = Math.min(result, j + 1 + Math.max(left, right));
                }
                dp[start][end] = result;
            }
        }
        return dp[0][n-1];
    }
}
