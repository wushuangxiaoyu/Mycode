package leetcode.arraysCode.productOfArrayExceptSelf;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @author Yu
 * @create 2018-08-08 19:04
 **/
public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        arr[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            arr[i] = nums[i + 1] * arr[i + 1];
        }
        int tmp = nums[0];
        nums[0] = 1;
        for (int i = 1; i < len; i++) {
            int m = nums[i];
            nums[i] = nums[i - 1] * tmp;
            tmp = m;
        }
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] * nums[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1, 2, 3, 4});
    }
}
