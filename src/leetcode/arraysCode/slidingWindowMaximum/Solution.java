package leetcode.arraysCode.slidingWindowMaximum;

import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口最大值。
 *
 * @author Yu
 * @create 2018-07-17 12:14
 **/
public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0){
            return new int[0];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[i] = nums[queue.peekFirst()];
            if (i == queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i + k]) {
                queue.pollLast();
            }
            queue.addLast(i + k);
        }
        result[result.length - 1] = nums[queue.pollFirst()];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int[] ints = maxSlidingWindow(nums, 3);

    }
}
