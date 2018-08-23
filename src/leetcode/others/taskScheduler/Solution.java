package leetcode.others.taskScheduler;

import java.util.*;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * @author Yu
 * @create 2018-08-01 13:05
 **/
public class Solution {
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }
        LinkedList<Node> list = new LinkedList<>();
        HashMap<Character, Node> map = new HashMap<>();
        // HashMap<Node, Integer> timeMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.get(tasks[i]).size++;
            } else {
                Node node = new Node(tasks[i], 1);
                list.addLast(node);
                map.put(tasks[i], node);
            }
        }

        int res = 0;
        while (list.size() != 0) {
            Collections.sort(list, (Node n1, Node n2) -> {
                if (n1.time == n2.time) {
                    return n2.size - n1.size;
                } else {
                    return n1.time - n2.time;
                }
            });
            Node node = list.peekFirst();
            if (node.time > 0) {
                res++;
            } else {
                if (node.size == 1) {
                    list.pollFirst();
                    res++;
                } else {
                    node.size--;
                    node.time = n + 1;
                    res++;
                    list.addLast(list.pollFirst());
                }
            }
            redues(list);
        }
        return res;
    }

    private static void redues(LinkedList<Node> list) {
        for (Node node : list) {
            node.time = node.time == 0 ? 0 : node.time - 1;
        }
    }


    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}

class Node {
    char ch;
    int size;
    int time;

    public Node(char ch, int size) {
        this.ch = ch;
        this.size = size;
        this.time = 0;
    }
}

