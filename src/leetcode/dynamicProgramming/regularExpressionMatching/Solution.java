package leetcode.dynamicProgramming.regularExpressionMatching;

/**
 * 递归方法
 *
 * @author Yu
 * @create 2018-08-23 22:57
 **/
public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean isMatch(char[] str, char[] exp, int i, int j) {
        //j到顶了
        if (j == exp.length) {
            return i == str.length;
        }

        //j 上还有字符是 并 j是最后的字符 或者j+1 不是*
        if (j + 1 == exp.length || exp[j + 1] != '*') {
            /*
             *   i!=str.length : j上有字符 但是i已经提前结束了
             *   exp[j] == str[i] || exp[j] == '.' : exp[j] 必须=str[i] 或者 exp[j] = .
             *   isMatch(str, exp, i + 1, j + 1) : 这样 在递归判定下面的情况
             * */
            return i != str.length && (exp[j] == str[i] || exp[j] == '.') && isMatch(str, exp, i + 1, j + 1);
        }

        // j+1位置 有字符并且是 *
        while (i != str.length && (exp[j] == str[i] || exp[j] == '.')) {
            /*形如：
             *   a,a,a,_,_,_
             *   a,*,_,_,
             *   从零个a开始尝试开始尝试
             * */
            if (isMatch(str, exp, i, j + 2)) {
                return true;
            }
            i++;
        }
        /*形如：
         *   a,a,a,_,_,_
         *   c,*,_,_,
         *   已零个c,j+2开始尝试开始尝试
         * */
        return isMatch(str, exp, i, j + 2);
    }

}
