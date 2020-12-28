package com.feng.algorithmlists.动态规划.q300_最长上升子序列;

/**
 * Created by fengbei
 * on 20-10-30
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Solution {


    public static int lis(int[] s) {
        if (s.length == 0) {
            return 0;
        }

        int len = s.length;
        int max = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (s[i] > s[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 19, 18};
        System.out.println(lis(ints));
    }


//    j : 2   dp[j]: 1 i=  3   dp[i] ： 2
//    j : 2   dp[j]: 1 i=  4   dp[i] ： 2
//    j : 2   dp[j]: 1 i=  5   dp[i] ： 2
//    j : 3   dp[j]: 2 i=  5   dp[i] ： 3
//    j : 0   dp[j]: 1 i=  6   dp[i] ： 2
//    j : 3   dp[j]: 2 i=  6   dp[i] ： 3
//    j : 5   dp[j]: 3 i=  6   dp[i] ： 4
//    j : 0   dp[j]: 1 i=  7   dp[i] ： 2
//    j : 3   dp[j]: 2 i=  7   dp[i] ： 3
//    j : 5   dp[j]: 3 i=  7   dp[i] ： 4
//    j : 0   dp[j]: 1 i=  8   dp[i] ： 2
//    j : 3   dp[j]: 2 i=  8   dp[i] ： 3
//    j : 5   dp[j]: 3 i=  8   dp[i] ： 4
//            4


}
