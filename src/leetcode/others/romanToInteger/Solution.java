package leetcode.others.romanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author Yu
 * @create 2018-06-26 20:42
 **/
public class Solution {
    /**
     * @Description: leetcode 上更快的答案
     * @author Yu
     * @date 2018/6/26 21:31 
     */
    public int romanToInt2(String s) {
        int r = 0;
        char[] sArr = s.toCharArray();
        int last = 0, idx = 0;
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i] == 'I') {
                idx = 1;
            } else if (sArr[i] == 'V') {
                idx = 5;
            } else if (sArr[i] == 'X') {
                idx = 10;
            } else if (sArr[i] == 'L') {
                idx = 50;
            } else if (sArr[i] == 'C') {
                idx = 100;
            } else if (sArr[i] == 'D') {
                idx = 500;
            } else if (sArr[i] == 'M') {
                idx = 1000;
            }
            if (idx >= last) {
                r += idx;
            } else {
                r -= idx;
            }
            last = idx;
        }
        return r;
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (map.get(chars[i]) > map.get(chars[i - 1])) {
                sum = sum + map.get(chars[i]) - map.get(chars[i - 1]);
                if(i==chars.length-1){
                    return sum;
                }
                i++;
            }
            else {
                sum = sum +map.get(chars[i-1]);
            }
        }
        return sum + map.get(chars[chars.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

