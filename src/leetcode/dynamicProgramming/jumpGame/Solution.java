package leetcode.dynamicProgramming.jumpGame;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * @author Yu
 * @create 2018-07-25 12:24
 **/
public class Solution {
    public static boolean canJump(int[] nums) {
        return process(nums, 0);
    }

    private static boolean process(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (nums[i] == 0 || i >= nums.length) {
            return false;
        }
        boolean f = false;
        for (int j = 1; j <= nums[i]; j++) {
            f = f || process(nums, i + j);
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0}));
    }
}
