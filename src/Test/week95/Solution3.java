package Test.week95;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-29 9:59
 **/
public class Solution3 {
    public static int nthMagicalNumber(int N, int A, int B) {
        int tmp = get_lcm(A, B);
        long start = (long) N * (long) tmp;
        for (long i = start; i >= 0; i = i - tmp) {
            if (i % A != 0 && i % B != 0) {
                continue;
            }
            long j = i / A + i / B - i / tmp;
            if (j == N) {
                return (int) (i % (Math.pow(10, 9) + 7));
            }
            if (j < N) {
                for (int x = 1, y = 1; x * A <= tmp || y * B <= tmp; ) {
                    long n = i + x * A;
                    long n2 = i + y * B;
                    if (n < n2) {
                        x++;
                    }
                    else {
                        n = n2;
                        y++;
                    }
                    if (n / A + n / B - n / tmp == N) {
                        return (int) (n % (Math.pow(10, 9) + 7));
                    }
                }
            }
        }
        return 0;
    }

    public static int get_gcd(int n1, int n2) {
        int gcd = 0;
        if (n1 < n2) {// 交换n1、n2的值
            n1 = n1 + n2;
            n2 = n1 - n2;
            n1 = n1 - n2;
        }

        if (n1 % n2 == 0) {
            gcd = n2;
        }

        while (n1 % n2 > 0) {
            n1 = n1 % n2;

            if (n1 < n2) {
                n1 = n1 + n2;
                n2 = n1 - n2;
                n1 = n1 - n2;
            }

            if (n1 % n2 == 0) {
                gcd = n2;
            }
        }
        return gcd;

    }

    // 最小公倍数
    public static int get_lcm(int n1, int n2) {
        return n1 * n2 / get_gcd(n1, n2);
    }


    public static void main(String[] args) {
        /*System.out.println(1);

        System.out.println(nthMagicalNumber(3, 6, 4));*/

        System.out.println(nthMagicalNumber(1000000000, 39999, 40000));
    }

}
