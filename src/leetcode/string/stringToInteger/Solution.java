package leetcode.string.stringToInteger;

/**
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 *
 * @author Yu
 * @create 2018-06-24 17:36
 **/
public class Solution {
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        char first = str.charAt(0);
        int i = 1;
        if (first == '-') {
            //负数
            char[] chars = str.toCharArray();
            for (; i < chars.length; i++) {
                if (!(chars[i] >= '0' && chars[i] <= '9')) {
                    break;
                }
            }
            if(i==1){
                return 0;
            }
            try {
                return Integer.parseInt(String.valueOf(chars, 0, i));
            } catch (Exception e) {
                return Integer.MIN_VALUE;
            }
        } else if (first == '+'|| (first >= '0' && first <= '9')) {
            //正数
            char[] chars = str.toCharArray();
            for (; i < chars.length; i++) {
                if (!(chars[i] >= '0' && chars[i] <= '9')) {
                    break;
                }
            }
            if(first=='+'&&i==1){
                return 0;
            }
            try {
                return Integer.parseInt(String.valueOf(chars, 0, i));
            } catch (Exception e) {
                return Integer.MAX_VALUE;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }
}
