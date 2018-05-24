package leetcode.arraysCode.rotateImage;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * @author Yu
 * @create 2018-05-23 15:49
 **/
public class Solution {
    public static void rotate(int[][] matrix) {
        int i = 0;
        int j = 0;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        while (i < m && j  < n) {
            rotateEdge(matrix, i++, j++, m--, n--);
        }

    }

    private static void rotateEdge(int[][] matrix, int i, int j, int m, int n) {
        swap(matrix, i, j, i, n);
        swap(matrix, i, j, m, n);
        swap(matrix, i, j, m, j);
        int j2 = j + 1, m2 = i + 1;
        while (j2 < n) {
            swap(matrix, i, j2++, m2++, n);
        }
        j2 = j + 1;
        int n2 = n - 1;
        while (j2 < n) {
            swap(matrix, i, j2++, m, n2--);
        }
        j2 = j + 1;
        m2 = m - 1;
        while (j2 < n) {
            swap(matrix, i, j2++, m2--, j);
        }
    }

    private static void swap(int[][] matrix, int i, int j, int m, int n) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        for (int[] rows : matrix) {
            for (int item : rows) {
                System.out.print(item + "  ");
            }
            System.out.println("");
        }
        rotate(matrix);
        System.out.println("------------------------");
        for (int[] rows : matrix) {
            for (int item : rows) {
                System.out.print(item + "  ");
            }
            System.out.println("");
        }
    }
}