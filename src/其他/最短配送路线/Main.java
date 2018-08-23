package 其他.最短配送路线;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-04 19:23
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        LinkedList<Point> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            linkedList.add(new Point(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
        }
        System.out.println(process(linkedList, 0, 0, 0));
    }

    private static int process(LinkedList<Point> linkedList, int sS, int sE, int len) {
        if (linkedList.size() == 1) {
            Point point = linkedList.get(0);
            return len + point.getLength(sS, sE) + point.getLength(0, 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < linkedList.size(); i++) {
            Point remove = linkedList.remove(i);
            min = Math.min(process(linkedList, remove.x, remove.y, len + remove.getLength(sE, sE)), min);
            linkedList.add(i, remove);
        }
        return min;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getLength(int px, int py) {
        return Math.abs(x - px) + Math.abs(y - py);
    }

}

