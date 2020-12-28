package com.feng.algorithmlists.双指针遍历.q121_卖股票的最佳时机;

/**
 * Created by fengbei
 * on 20-12-25
 * 找当前最小数，以及它后边的数与它的最大差值。
 * <p>
 * 示例 1: 输入: [7,1,5,3,6,4]输出: 5解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 */
public class Solution {
    public int maxprofit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int money = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                //  取下一个最小值,找最小的指针
                min = prices[i];
            }

            if (prices[i] - min > money) {
                // 后指针向后移动，不断向后找最呆
                money = prices[i] - min;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxprofit(a));
    }
}
