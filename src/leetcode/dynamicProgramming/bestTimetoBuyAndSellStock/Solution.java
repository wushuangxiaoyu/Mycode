package leetcode.dynamicProgramming.bestTimetoBuyAndSellStock;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * @author Yu
 * @create 2018-06-17 18:08
 **/
public class Solution {
    public static int maxProfit(int[] prices) {
        int max = 0 ;
        int gain = 0;
        for(int i = 0 ;i<prices.length-1;i++){
            for(int j = i+1;j<prices.length;j++) {
                gain = Math.max(gain, prices[j]-prices[i]);
            }
            max = Math.max(max,gain);
        }
        return max;
    }

    //leetcode 上最快的
    public static int maxProfit2(int[] prices) {
        if(prices.length==0)return 0;
        int res=0;
        int temp=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<temp&&i<prices.length-1)temp=prices[i];
            else{
                if(prices[i]-temp>res)
                    res=prices[i]-temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,0,6,4};
        System.out.println(maxProfit2(prices));
    }
}
