package leetcode.arraysCode.increasingTripletSubsequence;

/**
 * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 *
 * @author Yu
 * @create 2018-07-17 14:35
 **/
public class Solution {
    /**
     * @Description: leetcode上运行时间相同的简洁代码
     * @date 2018/7/17 15:34
     */
    public boolean increasingTriplet2(int[] nums) {
        if(nums.length<3)return false;
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(m1>nums[i])
                m1=nums[i];
            if(m1<nums[i] && m2>nums[i])
                m2=nums[i];
            if(m2<nums[i])
                return true;
        }
        return false;
    }

    public static boolean increasingTriplet(int[] nums) {
        for (int i = 0, sum = 2; i < nums.length - 2; ) {
            if (nums[i + 1] <= nums[i]) {
                i++;
                continue;
            }
            int f = i + 1;
            for (int j = i + 1, nowIndex = i; j < nums.length; j++) {
                if (nums[j] > nums[nowIndex]) {
                    sum--;
                    nowIndex = j;
                } else if (sum != 2 && nums[j] > nums[i]) {
                    nowIndex = j;
                } else if (f == i + 1) {
                    f = j;
                }
            }
            if (sum <= 0) {
                return true;
            } else {
                i = f;
                sum = 2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums= new int[]{1, 2, 3, 4, 5};
        //int[] nums= new int[]{5, 4, 3, 2, 1};
        //int[] nums = new int[]{0, 4, 2, 1, 0, -1, -3};
        int[] nums = new int[]{2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }
}
