package leetcode.sortAndSearch.findFirstAndLastPositionOfElementInSortedArray;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author Yu
 * @create 2018-07-24 21:03
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums != null && nums.length != 0) {
            int l = 0, h = nums.length - 1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (nums[mid] == target) {
                    int i = mid;
                    while (i >= 0 && nums[i--] == nums[mid]) {
                    }
                    res[0] = i + 1;
                    while (i < nums.length && nums[i++] == nums[mid]) {
                    }
                    res[1] = i - 1;
                    break;
                } else if (nums[mid] > target) {
                    h = mid - 1;
                } else if (nums[mid] < target) {
                    l = mid + 1;
                }
            }
        }
        return res;
    }
}
