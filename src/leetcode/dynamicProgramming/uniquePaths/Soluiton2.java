package leetcode.dynamicProgramming.uniquePaths;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-26 13:40
 **/
public class Soluiton2 {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || m <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
