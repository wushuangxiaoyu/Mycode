package leetcode.arraysCode.intersectionOfTwoArrays2;

import java.util.Arrays;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * @author Yu
 * @create 2018-05-23 17:11
 **/
public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums1.length == 0) {
            return null;
        }
        int len = nums1.length > nums2.length ? nums2.length : nums1.length;
        int size = 0;
        int[] tmp = new int[len];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                tmp[size++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        /*int[] result = new int[size];
        for (int m = 0; m < size; m++) {
            result[m] = tmp[m];
        }
        return result;*/
        return Arrays.copyOfRange(tmp,0,size);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 1, 1, 4, 5};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = intersect(nums1, nums2);
        for (int item : intersect) {
            System.out.println(item);
        }
    }
}
