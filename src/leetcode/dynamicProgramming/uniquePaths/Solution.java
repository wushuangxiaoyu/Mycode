package leetcode.dynamicProgramming.uniquePaths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * @author Yu
 * @create 2018-07-26 13:26
 **/
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || m <= 0) {
            return 0;
        }
        return process(m, n, 0, 0);
    }

    private int process(int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (i == m - 1 & j == n - 1) {
            return 1;
        }
        int res = 0;
        if (i == m - 1) {
            res = process(m, n, i, j + 1);
        } else if (j == n - 1) {
            res = process(m, n, i + 1, j);
        } else {
            res = process(m, n, i, j + 1) + process(m, n, i + 1, j);
        }
        return res;
    }
}
