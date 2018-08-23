package leetcode.others.NthMagicalNumber;

/**
 * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
 * 返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
 *
 * @author Yu
 * @create 2018-07-29 9:59
 **/
public class Solution {
    public static int nthMagicalNumber(int N, int A, int B) {
        int mod = 1_000_000_007;
        int lcm = get_lcm(A, B);
        int M = lcm / A + lcm / B - 1;
        int q = N / M;
        int r = N % M;

        long res = (long) q * lcm % mod;
        if (r == 0) {
            return (int) res;
        }
        int[] head = new int[]{A, B};
        for (int i = 1; i < r; i++) {
            if (head[0] < head[1]) {
                head[0] += A;
            } else {
                head[1] += B;
            }
        }
        res += Math.min(head[0], head[1]);
        return (int) (res % mod);
    }

    //最小公约数
    public static int get_gcd(int x, int y) {
        if (x == 0) return y;
        return get_gcd(y % x, x);

    }

    // 最小公倍数
    public static int get_lcm(int x, int y) {

        return x * y / get_gcd(x, y);
    }


    public static void main(String[] args) {
        /*System.out.println(1);

        System.out.println(nthMagicalNumber(3, 6, 4));*/

        //System.out.println(nthMagicalNumber(1000000000, 39999, 40000));
        System.out.println(nthMagicalNumber(1, 2, 3));
    }

}
