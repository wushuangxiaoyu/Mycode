package leetcode.sortAndSearch.findPeakElement;

import leetcode.linkedList.LinkedListUtil;

import java.util.LinkedList;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * @author Yu
 * @create 2018-07-24 19:50
 **/
public class Solution {
    /**
     * @Description: leetcode上最快的 二分
     * @date 2018/7/24 20:52
     */
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int l = 0, r = nums.length - 1;
        while (true) {
            int mid = (l + r) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        int i = 0;
        for (i = 0; i < nums.length - 3; i++) {
            if (queue.peekFirst() == i + 1) {
                return i + 1;
            }
            if (nums[queue.peekFirst()] == nums[i]) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i + 3] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i + 3);
        }
        if (queue.peekFirst() == i + 1) {
            return i + 1;
        } else {
            if (nums[0] > nums[1]) {
                return 0;
            }
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{2,3,4,3,2,1}));
    }
}
