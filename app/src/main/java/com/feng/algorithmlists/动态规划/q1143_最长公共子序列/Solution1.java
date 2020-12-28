package com.feng.algorithmlists.动态规划.q1143_最长公共子序列;

/**
 * 动态规划 dp[i + 1][j + 1] = Math.max(dp[i+1][j], dp[i][j+1]) o(m*n)
 * <p>
 * 最长公共子串
 */
public class Solution1 {

    public static  int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("sdfasdfjwe", "fjwed"));
    }
}
