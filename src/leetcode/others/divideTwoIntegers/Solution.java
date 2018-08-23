package leetcode.others.divideTwoIntegers;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * @author Yu
 * @create 2018-07-28 20:27
 **/
public class Solution {
    public static int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (A > 0) == (B > 0) ? res : -res;
    }

    public static void main(String[] args) {
        //2147483647
        System.out.println((1 << 31) -1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(divide(Integer.MIN_VALUE,2));
    }
}
