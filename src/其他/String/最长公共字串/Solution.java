package 其他.String.最长公共字串;

/**
 * 最长公共子序列
 * 如果 求最长公共子序列 只需要还原动态规划即可
 *
 * @author Yu
 * @create 2018-08-23 13:58
 **/
public class Solution {

    public static int test(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[][] dp = new int[m][n];
        dp[0][0] = ch1[0] == ch2[0] ? 1 : 0;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], ch1[0] == ch2[1] ? 1 : 0);
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], ch1[0] == ch2[1] ? 1 : 0);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(test("1ab2345cd","12345ef"));
    }
}
