package com.feng.algorithmlists.动态规划.q1143_最长公共子序列;

/**
 * Created by fengbei
 * on 20-11-2
 * <p>
 * 两个字符串的最长公共子串
 */
public class Solution {

    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //  遍历循环数组
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //  如果两个字符相同，则上一个相同的dp再加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs("sdfasdfjwe", "fjwe"));
    }
}
