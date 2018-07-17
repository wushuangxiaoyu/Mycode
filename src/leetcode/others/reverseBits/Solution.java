package leetcode.others.reverseBits;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * @author Yu
 * @create 2018-06-26 22:13
 **/
public class Solution {
    //leetcode
    public int rever(int n) {
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
        while (sb.length() < 32) {
            sb.insert(0, 0);
        }
        sb.reverse();
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    //leetcode
    public int reverseBits2(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res=(res<<1) | (n & 1);
            n=n>>>1;
        }
        return res;
    }

    public static int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0 ;i<32-s.length();i++){
            stringBuilder.append("0");
        }
        s = new String(stringBuilder) + s;
        //      10100101000001111010011100
        //00000010100101000001111010011100
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        chars[0] = '0';
        s=new String(chars);
        //00111001011110000010100101000000
        return Integer.parseUnsignedInt(s,2);
    }

    public static void main(String[] args) {
        //964176192
        System.out.println(reverseBits(2));
    }
}
