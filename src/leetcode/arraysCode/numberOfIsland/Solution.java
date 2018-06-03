package leetcode.arraysCode.numberOfIsland;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * @author Yu
 * @create 2018-06-02 20:41
 **/
public class Solution {
    //DFS 递归实现
    public static int numIslands(char[][] grid) {
        if(grid == null ||grid.length == 0 || grid[0].length ==0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;

        int size = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    size++;
                    infect(grid, i, j, row, column);
                }
            }
        }
        return size;
    }

    private static void infect(char[][] grid, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 2;
        infect(grid, i - 1, j, row, column);
        infect(grid, i + 1, j, row, column);
        infect(grid, i, j + 1, row, column);
        infect(grid, i, j - 1, row, column);
    }

    public static void main(String[] args) {
//        char[][] matrix = new char[][]{
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
        char[][] matrix = new char[][]{};
        System.out.println(numIslands(matrix));
    }
}
