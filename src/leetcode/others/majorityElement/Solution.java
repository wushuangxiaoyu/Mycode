package leetcode.others.majorityElement;

import java.util.Random;


/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * @author Yu
 * @create 2018-07-31 20:16
 **/
public class Solution {
    public static int majorityElement(int[] nums) {
        int[] partition = partition(nums, 0, nums.length - 1, 0);
        while (partition[1]-partition[0]-1 <= nums.length/2){
            if(partition[0]-partition[2] > partition[3]-partition[1]){
                partition = partition(nums, partition[2], partition[0], nums[partition[2]]);
            }else {
                partition = partition(nums, partition[1], partition[3], nums[partition[1]]);
            }
        }
        return nums[partition[0]+1];
    }

    private static int[] partition(int[] nums, int l, int h, int val) {
        int low = l;
        int cur = low;
        int high = h;
        while (cur <= high) {
            if (nums[cur] == val) {
                cur++;
            } else if (nums[cur] < val) {
                swap(nums, low, cur);
                cur++;
                low++;
            } else {
                swap(nums, cur, high);
                high--;
            }
        }
        return new int[]{low - 1, high + 1, l, h};
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2} ));
    }

}
