package leetcode.others.missingNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * @author Yu
 * @create 2018-06-27 19:13
 **/
public class Solution {
    /**
     * @Description: 运用异或
     * @author Yu
     * @date 2018/6/27 20:45
     */
    public int missingNumber2(int[] nums)
    {
        /*此方法好想，运行对，但是提交不了，可能有overflow
       int sum = (nums.length + 1) / 2 * nums.length;
        for (int num : nums)
        {
            sum -= num;
        }
        return sum;
        */

        int res=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            res^=i^nums[i];//主要就是利用 0 ^ a = a， 以及 a ^ b ^ a = b
        }
        return res;
    }

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<nums.length ;i++ ){
            set.add(nums[i]);
        }
        for( int i = 0 ;i<nums.length+1;i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
