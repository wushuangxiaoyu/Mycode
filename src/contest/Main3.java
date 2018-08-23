package contest;


import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-20 20:32
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
           list[i] = sc.nextInt();
        }
        int[] dp = new int[len];
        dp[0] = list[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + list[i], list[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

}
