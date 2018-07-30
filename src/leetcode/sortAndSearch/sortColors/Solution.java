package leetcode.sortAndSearch.sortColors;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 仅使用常数空间的一趟扫描算法
 *
 * @author Yu
 * @create 2018-07-23 17:23
 **/
public class Solution {
    public static void sortColors(int[] nums) {
        int low = 0, cur = 0;
        int high = nums.length - 1;
        while (cur <= high) {
            if (nums[cur] > 1) {
                swap(nums, cur, high--);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur++, low++);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {2, 1, 0, 1, 0, 1, 1, 1, 2};
        sortColors(ints);
    }
}
