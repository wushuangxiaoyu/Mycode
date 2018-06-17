package leetcode.dynamicProgramming.houseRobber;

/**
 * 动态规划
 *
 * @author Yu
 * @create 2018-06-17 21:07
 **/
public class Solution2 {
    public static int rob(int[] nums) {
        if(nums==null || nums.length == 0) {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] gain = new int[nums.length];
        gain[0] = nums[0];
        gain[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<gain.length;i++){
            if(gain[i-1]>gain[i-2]+nums[i]){
                gain[i] = gain[i-1];
            }
            else {
                gain[i] = gain[i-2]+nums[i];
            }
        }
        return gain[gain.length-1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
    }
}
