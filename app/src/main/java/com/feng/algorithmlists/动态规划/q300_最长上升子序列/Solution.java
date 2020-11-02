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

        int[] dp = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            //  初始化dp,默认为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (s[j] < s[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }


        //  遍历dp[]找到最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis(ints));
    }
}
