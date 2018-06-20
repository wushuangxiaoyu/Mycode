package leetcode.others.countPrimes;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @author Yu
 * @create 2018-06-19 16:39
 **/
public class Solution {
    public static int countPrimes(int n) {
        if (n < 1) {
            return 0;
        }
        boolean[] counts = new boolean[n];
        counts[0] = true;
        counts[1] = true;

        for (int i = 2; i * i < n; i++) {
            if (!counts[i]) {
                for (int j = 2 * i; j <n; j+=i) {
                    counts[j] = true;
                }
            }
        }
        int result = 0;
        for (boolean item : counts) {
            if (!item) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
