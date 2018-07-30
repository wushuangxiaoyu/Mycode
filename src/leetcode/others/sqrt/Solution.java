package leetcode.others.sqrt;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @author Yu
 * @create 2018-07-28 19:55
 **/
public class Solution {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0;
        int h = Math.min(x >> 1, 46340);
        if (x >= 46340 * 46340) {
            return 46340;
        }
        while (l <= h) {
            int i = (l + h) >> 1;
            if (i * i > x) {
                h = i - 1;
            } else if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            } else {
                l = i + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        //2147483647
        //2147395599
        System.out.println(mySqrt(2147483647));
    }
}
