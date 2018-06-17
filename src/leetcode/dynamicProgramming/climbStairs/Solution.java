package leetcode.dynamicProgramming.climbStairs;

/**
 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 递归版本
 * @author Yu
 * @create 2018-06-17 16:37
 **/
public class Solution {
    static  int count = 0;
    public static int climbStairs(int n) {
        count = 0;
        process(n,0);
        return count;
    }

    public static void process(int n,int now){
        if(now==n){
            count++;
        }
        if(now>n){
            return;
        }
        process(n,now+1);
        process(n,now+2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
