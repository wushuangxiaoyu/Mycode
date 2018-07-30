package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）
 *
 * @author Yu
 * @create 2018-07-23 14:58
 **/
public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        process(nums,new ArrayList<Integer>(),0);
        return result;
    }

    public void process(int[] nums,List<Integer> list,int i){
        if(i==nums.length){
            result.add(list);
            return;
        }
        process(nums,list,i+1);
        ArrayList<Integer> tmp = new ArrayList<>(list);
        tmp.add(nums[i]);
        process(nums,tmp,i+1);
    }
}
