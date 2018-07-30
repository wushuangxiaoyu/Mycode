package leetcode.dynamicProgramming.coinChange;


/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @author Yu
 * @create 2018-07-26 13:54
 **/
public class Solution {
    public static int coinChange(int[] coins, int amount) {
        return process(coins, coins.length - 1, amount, 0);
    }

    public static int process(int[] coins, int i, int amount, int c) {
        if (amount == 0) {
            return c;
        }
        if (i == -1 && amount >= 0) {
            return -1;
        }
        int res = -1;
        for (int j = 0; j <= amount / coins[i]; j++) {
            int tmp = process(coins, i - 1, amount - j * coins[i], c + j);
            if (tmp == -1) {
                continue;
            }else if (res != -1) {
                res = Math.min(res, tmp);
            }else {
                res =tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
