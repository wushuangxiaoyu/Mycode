package leetcode.others.factorialTrailingZeroes;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * @author Yu
 * @create 2018-07-27 15:21
 **/
public class Solution {
    public static int trailingZeroes(int n) {
        if(n<5){
            return 0;
        }
        else return n/5 + trailingZeroes(n/5);
    }


    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(20));
        System.out.println(trailingZeroes(100));

    }
}
