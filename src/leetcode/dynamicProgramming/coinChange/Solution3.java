package leetcode.dynamicProgramming.coinChange;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-26 16:27
 **/
public class Solution3 {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = -1;
        for (int i = 0; i < coins.length; i++) {
            int tmp = coinChange(coins, amount - coins[i]);
            if (tmp == -1) {
                continue;
            } else if (res != -1) {
                res = Math.min(res,tmp);
            }else {
                res = tmp;
            }
        }
        return res +1;
    }
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
