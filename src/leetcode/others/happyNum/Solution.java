package leetcode.others.happyNum;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快
 *
 * @author Yu
 * @create 2018-07-27 15:00
 **/
public class Solution {
    public boolean isHappy(int n) {
        if (n < 10) {
            return n == 1 || n == 7;
        }
        int newsum = 0;
        while (n != 0) {
            int digit = n % 10;
            newsum += digit*digit;
            n /= 10;
        }
        //System.out.println(newsum);
        return isHappy(newsum);
    }
}
