package leetcode.backtracking.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个有重复数字的序列，返回其所有可能的全排列。
 *
 * @author Yu
 * @create 2018-07-22 14:47
 **/
public class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[i] <nums[j]){
                    swap(nums,i,j);
                    Arrays.sort(nums,i+1,nums.length);
                    List<Integer> list = new ArrayList<>();
                    for(int m= 0 ;m<nums.length;m++){
                        list.add(nums[m]);
                    }
                    result.add(list);
                    i = nums.length-1;
                }
            }
        }
        return result;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
    }
}
