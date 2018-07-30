package Test.week95;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-07-29 9:49
 **/
public class Solution2 {
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
