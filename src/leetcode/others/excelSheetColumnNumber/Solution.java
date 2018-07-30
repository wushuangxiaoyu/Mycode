package leetcode.others.excelSheetColumnNumber;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-27 15:37
 **/
public class Solution {
    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += Math.pow(26, chars.length - i - 1) * (chars[i] - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}
