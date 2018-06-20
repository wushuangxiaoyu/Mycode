package leetcode.designProblems.shuffleAnArray;

import java.util.Random;

/**384
 *打乱一个没有重复元素的数组。
 *
 * @author Yu
 * @create 2018-06-18 15:11
 **/
class Solution {
    private int[] array;
    private int[] origin;
    private Random random;

    public Solution(int[] nums) {
        array = nums;
        origin = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        array = origin.clone();
        return array;
    }


    public int[] shuffle() {
        for(int i = 0; i<array.length;i++){
            swap(array,i,random.nextInt(array.length-i)+i);
        }
        return array;
    }

    public void swap(int[] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}