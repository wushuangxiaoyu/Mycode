package leetcode.dynamicProgramming.maximumLengthOfRepeatedSubarray;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * @author Yu
 * @create 2018-08-23 18:49
 **/
public class Solution {
    public static int findLength(int[] A, int[] B) {
        return getMax(A, B);

    }

    private static int getMax(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[][] dp = new int[m][n];
        int max= 0;
        for (int i = 0; i < m; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = 1;
                max =1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (b[i] == a[0]) {
                dp[0][i] = 1;
                max =1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}
