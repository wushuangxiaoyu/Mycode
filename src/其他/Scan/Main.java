package 其他.Scan;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-02 20:59
 **/


public class Main {
    static Point Start = new Point(0, 0);
    static int minPath = Integer.MAX_VALUE;

    public static int caculate(Point start, Point[] points, int sum, int count) {
        if (count == points.length) {
            minPath = Math.min(minPath, sum + start.getLength(Start));
            return minPath;
            //所以的点都遍历完之后返回最小的路径
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i].visted == false) {
                sum += points[i].getLength(start);
                if (sum < minPath) {
                    points[i].visted = true;
                    caculate(points[i], points, sum, count + 1);
                }
                sum -= points[i].getLength(start);
                points[i].visted = false;

            }

        }
        return minPath;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Point[] num = null;
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            num = new Point[n];
            for (int i = 0; i < n; i++) {
                num[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }
        }*/
        Point[] num = new Point[4];
        num[0] = new Point(2,2);
        num[1] = new Point(2,8);
        num[2] = new Point(4,4);
        num[3] = new Point(7,2);
        System.out.print(caculate(Start, num, 0, 0));
    }
}

class Point {
    int x;
    int y;
    boolean visted;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.visted = false;
    }

    public int getLength(Point point) {
        return Math.abs(x - point.x) + Math.abs(y - point.y);
    }

}
