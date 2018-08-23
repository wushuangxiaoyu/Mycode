package leetcode.others.boatsToSavePeople;

import java.util.Arrays;

/**
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * @author Yu
 * @create 2018-08-16 19:45
 **/
public class Solution {
    public static int numRescueBoats(int[] people, int limit) {
        int h = people.length - 1;
        int l = 0;
        int res = 0;
        Arrays.sort(people);
        while (l < h) {
            if (people[h] + people[l] <= limit) {
                l++;
            }
            res++;
            h--;
        }
        return l == h && people[l] <= limit ? res + 1 : res;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,1,2},3));
    }

}
