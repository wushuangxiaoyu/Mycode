package leetcode.arraysCode.mergeSortedArray;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * @author Yu
 * @create 2018-06-03 22:43
 **/
public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
            for (int j = m + i; j > 0; j--) {
                if (nums1[j] < nums1[j - 1]) {
                    int tmp = nums1[j];
                    nums1[j] = nums1[j - 1];
                    nums1[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * @Description: leetcode 上最快的 ，归并呐
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }

    }
}
