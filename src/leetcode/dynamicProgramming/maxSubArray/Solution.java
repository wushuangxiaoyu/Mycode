package leetcode.dynamicProgramming.maxSubArray;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author Yu
 * @create 2018-06-17 17:18
 **/
public class Solution {
    public static int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length]; int max = nums[0]; dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i] ,nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int tmp = nums[0];
        for(int i = 1; i<nums.length;i++){
            //tmp = tmp + nums[i];
            tmp = Math.max(tmp + nums[i],nums[i]);
            max = Math.max(max,tmp);
            if(max == nums[i]){
                tmp =max;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        //System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
