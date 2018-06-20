package leetcode.string.reverseString;

/**
 *请编写一个函数，其功能是将输入的字符串反转过来
 *
 * @author Yu
 * @create 2018-06-20 19:01
 **/
public class Solution {
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = chars.length-1 ;i>=0;i--){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
