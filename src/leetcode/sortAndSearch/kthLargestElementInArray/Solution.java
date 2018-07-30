package leetcode.sortAndSearch.kthLargestElementInArray;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author Yu
 * @create 2018-07-23 21:20
 **/
public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        return process(Arrays.copyOf(nums, nums.length), 0, nums.length - 1, k - 1);
    }

    private static int process(int[] nums, int begin, int end, int k) {
        if (begin == end) {
            return nums[begin];
        }
        int point = BFPRTPoint(nums, begin, end);
        int[] range = partition(nums, begin, end, point);
        if (range[0] <= k && range[1] >= k) {
            return nums[k];
        } else if (range[0] > k) {
            return process(nums, 0, range[0] - 1, k);
        } else {
            return process(nums, range[1] + 1, end, k);
        }
    }

    private static int[] partition(int[] nums, int begin, int end, int pointValue) {
        int low = begin, cur = begin;
        int high = end;
        while (cur <= high) {
            if (nums[cur] == pointValue) {
                cur++;
            } else if (nums[cur] < pointValue) {
                swap(nums, cur++, low++);
            } else {
                swap(nums, cur, high--);
            }
        }
        return new int[]{low, high};
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //寻找partition的起始点
    private static int BFPRTPoint(int[] nums, int begin, int end) {
        int counts = end - begin + 1;
        int offset = counts % 5 == 0 ? 0 : 1;
        //创建中位数数组
        int[] arr = new int[counts / 5 + offset];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getMid(nums, begin + i * 5, Math.min(end, begin + i * 5 + 4));
        }
        return process(arr, 0, arr.length - 1, arr.length / 2);
    }

    private static int getMid(int[] nums, int start, int end) {
        insertSort(nums, start, end);
        return nums[start + (end - start) / 2];
    }

    private static void insertSort(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        System.out.println((findKthLargest(arr, 13)));
    }
}
