package leetcode.dynamicProgramming.jumpGame2;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-25 18:47
 **/
public class Solution2 {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            while (step > 0) {
                if (step + i < nums.length) {
                    dp[i + step] = Math.min(dp[i] + 1, dp[i + step]);
                }
                step--;
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {

    }
}
