package leetcode.arraysCode.addOne;


import java.util.Arrays;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author Yu
 * @create 2018-05-20 20:17
 **/
public class Solution {
    public static int[] plusOne(int[] digits) {
       for(int i = digits.length-1 ;i>=0;i--){
           if(digits[i]!=9){
               digits[i]++;
               int j = i+1;
               while(j<digits.length){
                   digits[j] = 0;
                   j++;
               }
               return digits;
           }
       }
       digits = new int[digits.length+1];
       digits[0]=1;
       return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{8,9,9,9};
        digits = plusOne(digits);
        for (int i : digits) {
            System.out.println(i);
        }
    }
}
