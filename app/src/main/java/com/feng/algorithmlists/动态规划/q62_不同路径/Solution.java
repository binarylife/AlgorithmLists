package com.feng.algorithmlists.动态规划.q62_不同路径;

/**
 * Created by fengbei
 * on 20-10-27
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * https://www.cnblogs.com/ysw-go/p/11805884.html
 */
public class Solution {

    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        //  将便捷值标记为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //  dp数组的累加1过程，当前dp[m][n] = dp[m-1][n]+dp[m][n-1]

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

}
