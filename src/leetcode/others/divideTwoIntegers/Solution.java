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
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend > 0) {
            if (divisor > 0) {
                int i = 0;
                while (dividend >= divisor) {
                    dividend = dividend - divisor;
                    i++;
                }
                return i;
            }
            if (divisor < 0) {
                int i = 0;
                divisor = -divisor;
                while (dividend >= divisor) {
                    dividend = dividend - divisor;
                    i++;
                }
                return -i;
            }
        }
        if (dividend < 0) {
            if (divisor > 0) {
                int i = 0;
                while (dividend >= 0) {
                    dividend = dividend + divisor;
                    i++;
                }
                return -(i-1);
            }
            if (divisor < 0) {
                int i = 0;
                while (dividend >= 0) {
                    dividend = dividend - divisor;
                    i++;
                }
                return i-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //2147483647
        System.out.println(Integer.MIN_VALUE);
    }
}
