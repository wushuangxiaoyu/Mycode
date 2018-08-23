package leetcode.others.restoreIPAddresses;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * @author Yu
 * @create 2018-08-10 10:05
 **/
public class Solution {
    static List<String> result;

    public static List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        int[] point = new int[3];
        process(s, 0, 0, point);
        return result;
    }

    private static void process(String s, int index, int count, int[] point) {
        if (index >= s.length()) {
            return;
        }
        if (count == 3) {
            if ((s.charAt(index) == '0' && index < s.length() - 1) ||
                    index + 3 < s.length() ||
                    Integer.valueOf(s.substring(index, s.length())) > 255) {
                return;
            } else {
                result.add(s.substring(0, point[0]) + "." +
                        s.substring(point[0], point[1]) + "." +
                        s.substring(point[1], point[2]) + "." +
                        s.substring(index, s.length())
                );
                return;
            }
        }
        if (s.charAt(index) == '0') {
            point[count] = index + 1;
            process(s, index + 1, count + 1, point);
        } else {
            point[count] = index + 1;
            process(s, index + 1, count + 1, point);
            point[count] = index + 2;
            process(s, index + 2, count + 1, point);
            if (index + 3 <= s.length() && Integer.valueOf(s.substring(index, index + 3)) <= 255) {
                point[count] = index + 3;
                process(s, index + 3, count + 1, point);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("0279245587303");
    }
}
