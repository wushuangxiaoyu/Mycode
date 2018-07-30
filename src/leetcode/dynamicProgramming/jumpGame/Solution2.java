package leetcode.dynamicProgramming.jumpGame;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-25 14:08
 **/
public class Solution2 {

    public static HashMap<Integer,Boolean> hashMap;

    public static boolean canJump(int[] nums) {
        hashMap = new HashMap<>();
        return process(nums, 0);
    }



    private static boolean process(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (nums[i] == 0 || i >= nums.length) {
            return false;
        }
        boolean f = false;
        for (int j = 1; j <= nums[i]; j++) {
            if(hashMap.containsKey(i+j)){
                f=f||hashMap.get(i+j);
            }else {
                f = f || process(nums, i + j);
            }
        }
        if(!hashMap.containsKey(i)){
            hashMap.put(i,f);
        }
        return f;
    }
}
