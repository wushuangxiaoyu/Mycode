package leetcode.arraysCode.containerWithMostWater;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author Yu
 * @create 2018-08-13 15:51
 **/
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int h = height.length - 1;
        while (h != l) {
            max = Math.max(max, (h - l) * Math.min(height[l], height[h]));
            if (height[l] < height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return max;
    }
}
