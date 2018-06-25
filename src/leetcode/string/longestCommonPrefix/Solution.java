package leetcode.string.longestCommonPrefix;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author Yu
 * @create 2018-06-25 15:31
 **/
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null || "".equals(strs[i])) {
                return "";
            }
            minLen = strs[i].length() < minLen ? strs[i].length() : minLen;
        }
        int i = 0;
        go:for (; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    break go;
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
