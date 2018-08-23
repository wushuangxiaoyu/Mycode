package leetcode.dynamicProgramming.jumpGame2;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-16 18:58
 **/
public class Solution {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            while (step + i > max) {
                if (step + i < nums.length) {
                    dp[i + step] = Math.min(dp[i] + 1, dp[i + step]);
                }
                step--;
            }
            max = nums[i] + i;
        }
        return dp[dp.length - 1];
    }
}
