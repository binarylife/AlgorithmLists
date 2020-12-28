package com.feng.algorithmlists.动态规划.q_01背包问题;

import android.provider.ContactsContract;

/**
 * Created by fengbei
 * on 20-11-23
 * <p>https://blog.csdn.net/u013885699/article/details/80248536#t2
 * 问题描述：
 * 一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
 * 那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
 * 1、0-1背包：每类物品最多只能装一次
 * 2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
 * 3、完全背包：每类物品可以无限次装进包内
 */
public class Solution {

    /**
     * 0-1背包问题
     *
     * @param V      背包容量
     * @param N      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */
    public static int zeroOnepack(int V, int N, int[] weight, int[] value) {
        //  初始化动态数组
        int[][] dp = new int[N + 1][V + 1];
        //  为了便于理解，将dp[i][0]和dp[0][j]均置为0，从1开始计算

        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[N][V];
    }

}
