package leetcode.arraysCode.rotateArray;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author Yu
 * @create 2018-05-13 0:27
 **/
public class Solution {
    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        k =  k %nums.length;
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
