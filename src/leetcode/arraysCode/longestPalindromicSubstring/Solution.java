package leetcode.arraysCode.longestPalindromicSubstring;

/**
 * 最长回文子串
 *
 * @author Yu
 * @create 2018-07-15 14:29
 **/
public class Solution {
    /**
     * @Description: Manacher算法
     * @author Yu
     * @date 2018/7/15 14:30
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = manacherString(s);
        int[] pArr = new int[chars.length];
        int index = -1;
        int pR = -1;
        int maxindex = 0;
        for (int i = 0; i < chars.length; i++) {
            pArr[i] = pR > i ? Math.min(pR - i, pArr[2 * index - i]) : 1;
            while (i + pArr[i] < chars.length && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            if (pArr[i] > pArr[maxindex]) {
                maxindex = i;
            }
        }
        return new String(chars, maxindex - pArr[maxindex] + 1, 2 * pArr[maxindex] - 1).replace("#","");
    }

    private static char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 2 + 1];
        for (int i = 0, j = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : chars[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        String babad = longestPalindrome("a");
        System.out.println(babad);
    }
}
