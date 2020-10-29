package com.feng.algorithmlists.动态规划.q70_爬楼梯问题;

/**
 * Created by fengbei
 * on 20-10-28
 * 你正在爬楼梯。需要 n 步你才能到达顶部。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 将是一个正整数。
 */
public class Solution {


    public static int climStairs(int n) {
        if (n == 1) {
            return 1;
        }


        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
