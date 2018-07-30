package leetcode.sortAndSearch.searchInRotatedSortedArray;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author Yu
 * @create 2018-07-25 9:56
 **/
public class Solution {
    public static int search(int[] nums, int target) {
        return process(nums, target, 0, nums.length - 1);
    }

    private static int process(int[] nums, int target, int l, int h) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[h] >= target) {
                    int t = process(nums, target, mid + 1, h);
                    if (t != -1) {
                        return t;
                    }
                }
                h = mid -1;
            } else {
                if (nums[l] <= target) {
                    int t = process(nums, target, l, mid - 1);
                    if (t != -1) {
                        return t;
                    }
                }
                l = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},3));
    }
}
