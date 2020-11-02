package com.feng.algorithmlists.动态规划.q746_使用最小话费爬楼梯;

/**
 * Created by fengbei
 * on 20-11-2
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 */
public class Solution {

    public static int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        //  设置dp数组
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];


        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == cost.length ? 0 : cost[i]);
        }
        return dp[cost.length];
    }


    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 2, 1};
        System.out.println(new Solution().minCostClimbingStairs(a));
        System.out.println(new Solution().minCostClimbingStairs2(a));
    }

    public static int minCostClimbingStairs2(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
