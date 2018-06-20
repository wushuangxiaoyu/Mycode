package leetcode.others.isPowerOfThree;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * @author Yu
 * @create 2018-06-20 13:19
 **/
public class Solution {
    //循环
    public static boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        for(int i = 3;i!=n;i*=3) {
            if (i > n)
                return false;
        }
        return true;
    }

    /**
     * @Description: 转换成三进制数则为 10000....
     * @author Yu
     * @date 2018/6/20 13:54 
     */
    public static boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }


    public static void main(String[] args) {

    }

}
