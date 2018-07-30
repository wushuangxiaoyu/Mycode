package leetcode.others.theSkylineProblem;


import leetcode.linkedList.ListNode;

import java.util.*;

/**
 * 218. 天际线问题
 *
 * @author Yu
 * @create 2018-07-18 19:55
 **/
public class Solution {
    public static List<int[]> getSkyline(int[][] buildings) {
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(buildings[i][0], buildings[i][2], true);
            nodes[i * 2 + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(nodes, (o1, o2) -> o1.point - o2.point);
        TreeMap<Integer, Integer> pH = new TreeMap<>();
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isUp) {
                //上升
                if (pH.containsKey(nodes[i].height)) {
                    pH.put(nodes[i].height, pH.get(nodes[i].height) + 1);
                } else {
                    pH.put(nodes[i].height, 1);
                }
            } else {
                //下降
                if (pH.containsKey(nodes[i].height)) {
                    if (pH.get(nodes[i].height) == 1) {
                        pH.remove(nodes[i].height);
                    } else {
                        pH.put(nodes[i].height, pH.get(nodes[i].height) - 1);
                    }
                }
            }
            //记录点的天际线
            if (pH.isEmpty()) {
                result.put(nodes[i].point, 0);
            } else {
                result.put(nodes[i].point, pH.lastKey());
            }
        }
        int height = 0;
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() != height) {
                int[] tmp = new int[]{entry.getKey(), entry.getValue()};
                list.add(tmp);
            }
            height = entry.getValue();
        }
        return list;
    }

    public static void main(String[] args) {
        getSkyline(new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        });
    }
}

class Node {
    int height;
    int point;
    boolean isUp;

    public Node(int point, int height, boolean isUp) {
        this.height = height;
        this.point = point;
        this.isUp = isUp;
    }
}
