package leetcode.dynamicProgramming.stoneGame;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * @author Yu
 * @create 2018-07-29 9:49
 **/
public class Solution {
    public static boolean stoneGame(int[] piles) {
        int[][] f = new int[piles.length][piles.length];
        int[][] s = new int[piles.length][piles.length];
        for (int j = 0; j < piles.length; j++) {
            f[j][j] = piles[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(piles[i] + s[i + 1][j], piles[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return f[0][piles.length - 1] > s[0][piles.length - 1] ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{3,4,5}));
    }
}
