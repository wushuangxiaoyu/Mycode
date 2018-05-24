package leetcode.arraysCode.twoSum;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * @author Yu
 * @create 2018-05-19 23:16
 **/
public class Solution {
    /**
     * @Description: 别人的代码
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int [] res = new int[2];
        if(numbers==null||numbers.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                res[0]= map.get(target-numbers[i]);
                res[1]= i;
                break;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int maxIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target - nums[0]) {
                maxIndex = i;
                break;
            }
        }
        for (int i = 0; i < maxIndex; i++) {
            int remain = target - nums[i];
            int index = selectIndex(nums, i, maxIndex - 1, remain);
            if (index != -1) {
                int[] result = new int[2];
                for (int j = 0, flag = 0; j < nums2.length; j++) {
                    if (nums2[j] == nums[i] || nums2[j] == nums[index]) {
                        result[flag++] = j;
                    }
                    if (flag == 2) {
                        break;
                    }
                }
                return result;
            }
        }
        return null;
    }

    /**
     * 二分查找
     **/
    public static int selectIndex(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] != target) {
                return -1;
            } else {
                return left;
            }
        }
        int mid = (right + left) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return selectIndex(nums, mid + 1, right, target);
        } else {
            return selectIndex(nums, left, mid, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, 4, 3, 90};
        int[] result = twoSum(nums, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
