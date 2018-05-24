package leetcode.arraysCode.singleNumber;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author Yu
 * @create 2018-05-14 9:36
 **/
public class Solution {

    public static int singleNumber2(int[] nums) {
        int result =0;
        for(int i = 0; i<nums.length; i++){
            result^=nums[i];
        }
        return result;
    }

    public static int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; j--) {
                nums[j] = nums[j+1] ^ nums[j];
                nums[j+1] = nums[j+1] ^ nums[j];
                nums[j] = nums[j+1] ^ nums[j];
            }
        }
        for (int i:nums) {
            System.out.print(i+" ");
        }
        System.out.println("");
        for(int i =1;i<nums.length-1;i++){
            if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[0]==nums[1]?nums[nums.length-1]:nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(singleNumber(nums));
    }
}
