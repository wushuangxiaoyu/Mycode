package leetcode.arraysCode.projectionAreaOf3DShapes;

/**
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回所有三个投影的总面积。
 * @author Yu
 * @create 2018-08-16 19:47
 **/

public class Solution {
    public static int projectionArea(int[][] grid) {
        int res = 0;
        int len = grid.length;
        for (int i = 0; i < len; i++) {
            int maxlen = 0;
            int maxlen2 = 0;
            for (int j = 0; j < len; j++) {
                maxlen = Math.max(maxlen, grid[i][j]);
                maxlen2 = Math.max(maxlen2, grid[j][i]);
                if (grid[i][j] > 0) {
                    res++;
                }
            }
            res = res + maxlen + maxlen2;
            maxlen = 0;
            maxlen2 = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{{1,3},{2,4}}));
    }
}

