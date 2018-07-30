package 其他.KMP;

/**
 * KMP
 *
 * @author Yu
 * @create 2018-07-29 17:06
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(kmp("bbc abcd ababcdabcdabde", "abcdabd"));
        System.out.println("bbc abcd ababcdabcdabde".indexOf("abcdabd"));
    }

    private static int kmp(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0 || target.length() > source.length()) {
            return -1;
        }
        char[] schars = source.toCharArray();
        char[] tchars = target.toCharArray();
        int[] nexts = getNext(tchars);
        int si = 0;
        int ti = 0;
        while (si < schars.length && ti < tchars.length) {
            if (schars[si] == tchars[ti]) {
                si++;
                ti++;
            } else if (nexts[ti] == -1) {
                si++;
            } else {
                ti = nexts[ti];
            }
        }
        return ti == tchars.length  ? si - ti : -1;
    }

    private static int[] getNext(char[] tchars) {
        int[] nexts = new int[tchars.length];
        int i = 0;
        int j = 2;
        nexts[0] = -1;
        nexts[1] = 0;
        while (j < nexts.length) {
            if (tchars[j - 1] == tchars[i]) {
                nexts[j++] = ++i;
            } else if (i > 0) {
                i = nexts[i];
            } else {
                nexts[j++] = 0;
            }
        }
        return nexts;
    }
}
