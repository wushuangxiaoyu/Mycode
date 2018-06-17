package leetcode.dynamicProgramming.houseRobber;

/**
 * 动态规划 优化版
 *
 * @author Yu
 * @create 2018-06-17 21:07
 **/
public class Solution3 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int num1 = nums[0];
        int num2 = Math.max(nums[0], nums[1]);
        int max = num2;
        for (int i = 2; i < nums.length; i++) {
            if (num2 > num1 + nums[i]) {
                max = num2;
            } else {
                max = num1 + nums[i];
            }

            num1 = num2;
            num2 = max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
    }
}
