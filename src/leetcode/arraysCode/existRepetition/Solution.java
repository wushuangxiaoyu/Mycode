package leetcode.arraysCode.existRepetition;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * @author Yu
 * @create 2018-05-14 9:23
 **/
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        return set.size() == nums.length ? false : true;
    }

    public static boolean containsDuplicate3(int[] nums) {
        if(nums.length==0||nums.length==1)
            return false;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        for (int i = 1; i < nums.length;i++){
            int j = i - 1;
            int temp = nums[j+1];
            while (j >= 0 && nums[j] > temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
            if (j >= 0 && nums[j] == nums[j+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(containsDuplicate(nums));
    }
}
