package leetcode.string.validPalindrome;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * @author Yu
 * @create 2018-06-24 16:31
 **/
public class Solution {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while (end > start) {
            if (!((chars[start] >= 'a' && chars[start] <= 'z') || (chars[start] >= '0') && chars[start] <= '9')) {
                start++;
                continue;
            }
            if (!((chars[end] >= 'a' && chars[end] <= 'z') || (chars[end] >= '0') && chars[end] <= '9')) {
                end--;
                continue;
            }
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
