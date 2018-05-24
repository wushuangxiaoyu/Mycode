package leetcode.arraysCode.removeDuplicates;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author Yu
 * @create 2018-05-12 9:39
 **/
public class Solution {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        for (int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[nums.length-1]){
                return i+1;
            }
            if(nums[i] == nums[i+1]){
                for(;i<nums.length-2;i++){
                    nums[i+1]=nums[i+2];
                }
                removeDuplicates(nums);
            }
        }
        for(int i =1;i<nums.length;i++){
            if(nums[i]==nums[nums.length-1]){
                return i+1;
            }
        }
        return nums.length;
       /* if(nums[0] == nums[nums.length-1]){
            return 1;
        }
        for (int i = 1;i<nums.length;i++){
            if(nums[i-1] == nums[nums.length-1]){
                if(i==nums.length-1){
                    return i;
                }
                return i+1;
            }
            if(nums[i-1] == nums[i]){
                for(;i<nums.length-1;i++){
                    if(nums[i-1] == nums[nums.length-1]){
                        break;
                    }
                    nums[i]=nums[i+1];
                }
                removeDuplicates(nums);
            }
        }
        for(int i =1;i<nums.length;i++){
            if(nums[i]==nums[nums.length-1]){
                return i+1;
            }
        }
        return nums.length;*/
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        //int[] nums = new int[]{1,1};
        //int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        //int[] nums = new int[]{1,2,2};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i< len; i++) {
            System.out.println(nums[i]);
        }
    }
}
