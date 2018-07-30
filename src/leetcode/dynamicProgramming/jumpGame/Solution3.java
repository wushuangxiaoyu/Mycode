package leetcode.dynamicProgramming.jumpGame;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-25 17:53
 **/
public class Solution3 {
    public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[nums.length] = false;
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            boolean f = false;
            for (int j = 1; j <= nums[i] && j < dp.length; j++) {
                f = f || dp[i + j];
            }
            dp[i] = f;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        canJump(new int[]{2,3,1,1,4});
    }
}
