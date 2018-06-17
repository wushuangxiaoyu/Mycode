package leetcode.dynamicProgramming.houseRobber;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 198
 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 递归 版本
 *
 * @author Yu
 * @create 2018-06-17 20:19
 **/
public class Solution {


    public static int rob(int[] nums) {
        return process(nums,0,0);
    }

    public static int process(int[] nums,int index,int nowGain){
        if(index >= nums.length){
            return nowGain;
        }
        return Math.max(process(nums,index+1,nowGain),process(nums,index+2,nowGain+nums[index]));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}

