package leetcode.others.pascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-06-27 18:39
 **/
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            triangle.add(new ArrayList<Integer>());
            triangle.get(i).add(1);
            for (int j = 1; j < triangle.get(i - 1).size(); j++) {
                triangle.get(i).add(triangle.get(i-1).get(j)+triangle.get(i-1).get(j-1));
            }
            triangle.get(i).add(1);
        }
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
    }
}
