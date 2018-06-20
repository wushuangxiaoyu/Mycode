package leetcode.others.fizzBuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * @author Yu
 * @create 2018-06-19 16:16
 **/
public class Solution {
    public static List<String> fizzBuzz(int n) {
        String[] list = new String[n];
        for (int i = 2; i < n; i += 3) {
            list[i] = "Fizz";
        }
        for (int i = 4; i < n; i += 5) {
            if (list[i] == null) {
                list[i] = "Buzz";
            } else {
                list[i] = list[i] + "Buzz";
            }
        }
        for (int i = 0; i < n; i++) {
            if (list[i] == null) {
                list[i] = String.valueOf(i+1);
            }
        }
        return Arrays.asList(list);
    }

    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        for (String item : strings) {
            System.out.println(item);
        }
    }
}
