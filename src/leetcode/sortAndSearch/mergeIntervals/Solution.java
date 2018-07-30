package leetcode.sortAndSearch.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * @author Yu
 * @create 2018-07-24 21:31
 **/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Node[] nodes = new Node[intervals.size() * 2];
        for (int i = 0; i < intervals.size(); i++) {
            nodes[i * 2] = new Node(intervals.get(i).start, false);
            nodes[i * 2 + 1] = new Node(intervals.get(i).end, true);
        }
        Arrays.sort(nodes, (Node n1, Node n2) -> n1.point - n2.point);
        List<Interval> result = new ArrayList<>();
        int count = 0;
        Interval in = null;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].isEnd) {
                count--;
                if (count == 0) {
                    in.end = nodes[i].point;
                    result.add(in);
                }
            } else {
                if (count == 0) {
                    in = new Interval();
                    in.start = nodes[i].point;
                }
                count++;
            }
        }
        for (int i = 1; i < result.size(); i++) {
            if(result.get(i).start==result.get(i-1).end){
                result.get(i-1).end =result.get(i).end;
                result.remove(i);
                i--;
            }
        }
        return result;
    }
}

class Node {
    int point;
    boolean isEnd;

    public Node(int point, boolean isEnd) {
        this.point = point;
        this.isEnd = isEnd;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
