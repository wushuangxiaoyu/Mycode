package leetcode.backtracking.wordSearch;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author Yu
 * @create 2018-07-23 15:20
 **/
public class Solution {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char[] chars = word.toCharArray();
                    Stack<Point> stack = new Stack<>();
                    Point point = new Point(i, j);
                    stack.push(point);
                    int l = 1;
                    HashMap<Point, Integer> map = new HashMap<>();
                    map.put(point, 0);
                    xx:
                    while (!stack.isEmpty()) {
                        if (l == chars.length) {
                            return true;
                        }
                        point = stack.peek();
                        int w = map.get(point);
                        while (w < 4) {
                            if (w == 0) {
                                if (isInBoard(point.x, point.y+1, board) && board[point.x][point.y+1] == chars[l] && !map.containsKey(new Point(point.x , point.y+1))) {
                                    map.put(point, ++w);
                                    Point p = new Point(point.x, point.y+1);
                                    stack.push(p);
                                    map.put(p, 0);
                                    l++;
                                    continue xx;
                                } else {
                                    w++;
                                }
                            } else if (w == 1) {
                                if (isInBoard(point.x+1, point.y , board) && board[point.x+1][point.y] == chars[l] && !map.containsKey(new Point(point.x+1, point.y))) {
                                    map.put(point, ++w);
                                    Point p = new Point(point.x+1, point.y);
                                    stack.push(p);
                                    map.put(p, 0);
                                    l++;
                                    continue xx;
                                } else {
                                    w++;
                                }
                            } else if (w == 2) {
                                if (isInBoard(point.x - 1, point.y, board) && board[point.x - 1][point.y] == chars[l] && !map.containsKey(new Point(point.x - 1, point.y))) {
                                    map.put(point, ++w);
                                    Point p = new Point(point.x - 1, point.y);
                                    stack.push(p);
                                    map.put(p, 0);
                                    l++;
                                    continue xx;
                                } else {
                                    w++;
                                }
                            } else if (w == 3) {
                                if (isInBoard(point.x, point.y - 1, board) && board[point.x][point.y - 1] == chars[l] && !map.containsKey(new Point(point.x, point.y - 1))) {
                                    map.put(point, ++w);
                                    Point p = new Point(point.x, point.y - 1);
                                    stack.push(p);
                                    map.put(p, 0);
                                    l++;
                                    continue xx;
                                } else {
                                    w++;
                                }
                            }
                        }
                        map.remove(stack.pop());
                        l--;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isInBoard(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"BCCFB"));
    }

}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
