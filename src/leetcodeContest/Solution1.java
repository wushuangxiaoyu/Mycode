package leetcodeContest;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-31 13:59
 **/
public class Solution1 {
    public static long Solve(int n, int[] num) {
        return process(0, n, num);
    }

    private static int process(int s, int n, int[] num) {
        if (s >= n - 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= num[s]&&s+i<=n; i++) {
            res += process(s + i, n, num);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solve(7,new int[]{2,2,3,3,2,3,3}));
    }
}
