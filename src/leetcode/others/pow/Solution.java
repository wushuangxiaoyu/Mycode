package leetcode.others.pow;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * @author Yu
 * @create 2018-07-27 20:53
 **/
public class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        if (n == 2) {
            return x * x;
        }
        if ((n & 1) == 0) {
            return myPow(myPow(x, n / 2), 2);
        }else {
            return x * myPow(myPow(x,n/2),2);
        }
    }

    public static void main(String[] args) {
        //1024.00000
        //9.26100
        //0.25000
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }
}
