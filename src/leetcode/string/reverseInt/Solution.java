package leetcode.string.reverseInt;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * @author Yu
 * @create 2018-06-20 19:18
 **/
public class Solution {
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        if(x<0){
            reverseBy(chars,1,chars.length-1);
        } else{
            reverseBy(chars,0,chars.length-1);
        }
        try{
            return Integer.parseInt(new String(chars));
        }catch (Exception e){
            return 0;
        }
    }

    public static void reverseBy(char[] chars,int start,int end){
        while(start<=end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
