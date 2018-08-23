package contest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-19 16:56
 **/
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = Integer.valueOf(sc.nextLine());
        int n = Integer.valueOf(sc.nextLine());
        int[][] nums = new int[m][n];
        UnionSet unionSet = new UnionSet();
        int count = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String[] split = sc.nextLine().split(" ");
            int x = Integer.valueOf(split[0]);
            int y = Integer.valueOf(split[1]);
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            Node xy = new Node(x, y);
            unionSet.insertNode(xy);
            if (x - 1 >= 0 && nums[x - 1][y] == -1) {
                unionSet.unionNode(xy, new Node(x - 1, y));
            }
            if (y - 1 >= 0 && nums[x][y - 1] == -1) {
                unionSet.unionNode(xy, new Node(x, y-1));
            }
            if (x + 1 < m && nums[x + 1][y] == -1) {
                unionSet.unionNode(xy, new Node(x + 1, y));
            }
            if (y + 1 < n && nums[x][y + 1] == -1) {
                unionSet.unionNode(xy, new Node(x, y + 1));
            }
            nums[x][y] = -1;
            System.out.print(unionSet.getSetSize() + " ");
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.x == this.x && node.y == this.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        result = prime*result+x;
        result = prime*result+y;
        return result;
    }
}

class UnionSet {
    public HashMap<Node, Node> fatherMap;
    public HashMap<Node, Integer> sizeMap;

    public UnionSet() {
        this.fatherMap = new HashMap<>();
        this.sizeMap = new HashMap<>();
    }

    public int getSetSize() {
        return sizeMap.size();
    }

    public void insertNode(Node node) {
        fatherMap.put(node, node);
        sizeMap.put(node, 1);
    }

    private Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public void unionNode(Node x, Node y) {
        if (x == null || y == null) {
            return;
        }
        Node xHead = findHead(x);
        Node yHead = findHead(y);
        if (xHead != yHead) {
            int xSetSize = sizeMap.get(xHead);
            int ySetSize = sizeMap.get(yHead);
            if (xSetSize <= ySetSize) {
                fatherMap.put(xHead, yHead);
                sizeMap.put(yHead, xSetSize + ySetSize);
                sizeMap.remove(xHead);
            } else {
                fatherMap.put(yHead, xHead);
                sizeMap.put(xHead, xSetSize + ySetSize);
                sizeMap.remove(yHead);
            }
        }
    }
}
