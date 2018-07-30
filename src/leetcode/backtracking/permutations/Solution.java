package leetcode.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * @author Yu
 * @create 2018-07-22 13:54
 **/
public class Solution {

    List<List<Integer>> list;

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        process(nums, 0);
        return list;
    }

    private void process(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            list.add(l);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums,start,i);
            process(nums,start+1);
            swap(nums,start,i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
