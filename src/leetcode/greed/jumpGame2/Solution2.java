package leetcode.greed.jumpGame2;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-25 18:47
 **/
public class Solution2 {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int f = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i] && i + j < dp.length; j++) {
                if (dp[i + j] >= 0 && dp[i + j] <= f) {
                    f = dp[i + j];
                }
            }
            dp[i] = f + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
