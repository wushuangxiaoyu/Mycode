package leetcode.dynamicProgramming.coinChange;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-26 16:36
 **/
public class Solution4 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }
                int tmp = dp[i - coins[j]];
                if (tmp == -1) {
                    continue;
                }
                if (dp[i] == -1) {
                    dp[i] = tmp + 1;
                } else {
                    dp[i] = Math.min(dp[i], tmp + 1);
                }
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
