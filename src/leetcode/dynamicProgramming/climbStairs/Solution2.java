package leetcode.dynamicProgramming.climbStairs;

/**
 * 动态规划
 *
 * @author Yu
 * @create 2018-06-17 16:46
 **/
public class Solution2 {
    public static int climbStairs(int n) {
        int[] arr = new int[n+1];
        arr[1]=1;
        arr[2]=2;
        for(int i =3;i<arr.length;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
