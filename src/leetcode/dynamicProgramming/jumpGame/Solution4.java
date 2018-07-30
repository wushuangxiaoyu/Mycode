package leetcode.dynamicProgramming.jumpGame;

/**
 *
 * @author leetcode
 * @create 2018-07-25 18:16
 **/
public class Solution4 {
    public boolean canJump(int[] nums) {
        if(nums.length==0 || nums.length==1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]==0) return false;
            dp[i] = Math.max(nums[i],dp[i-1]-1);
        }
        if(dp[nums.length-2]>0) return true;
        else return false;
    }
}
