package leetcode.dynamicProgramming.coinChange;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-26 14:39
 **/
public class Solution2 {
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j != 0) {
                    if (j % coins[i] == 0) {
                        dp[i][j] = j / coins[i];
                    } else {
                        dp[i][j] = -1;
                    }
                    continue;
                }
                int res = -1;
                for (int m = 0; m * coins[i] <= j; m++) {
                    int tmp = dp[i - 1][j - m * coins[i]];
                    if (tmp == -1) {
                        continue;
                    } else if (res != -1) {
                        res = Math.min(res, tmp + m);
                    } else {
                        res = tmp + m;
                    }
                }
                dp[i][j] = res;
            }
        }
        return dp[coins.length - 1][amount];
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
