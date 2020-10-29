package com.feng.algorithmlists.动态规划.q5_最长回文子串.f1;

import android.text.StaticLayout;

/**
 * Created by fengbei
 * on 20-10-21
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb
 * <p>
 * * 动态规划 o(n^2)
 * * 转移方程：字符串两边界值相等并且子字符串是回文字符串则该字符串是回文字符串
 * * dp数组含义：字符串s从i到j的索引子字符串是否是回文字符串
 */
public class Solution {

    public static String longestStrings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        if (length < 2) {
            return s;
        }
        //  创建dp数组
        boolean[][] dp = new boolean[length][length];

        //最长回文子串的长度
        int maxLent = 1;
        //起始位置
        int start = 0;

        // i表示终点位置，j表示起点位置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j < 2) {
                    //  相邻的子串
                    dp[j][i] = chars[j] == chars[i];
                } else {
                    // 如果 [i, j] 是回文子串，那么一定有 [j+1, i-1] 也是回子串
                    dp[j][i] = dp[j + 1][i - 1] && chars[j] == chars[i];
                }

                if (dp[j][i] && (i - j + 1 > maxLent)) {
                    maxLent = i - j + 1;
                    start = j;
                }
            }
        }

        return s.substring(start, maxLent);
    }


    /**
     * 其他解
     *
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }


        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }


        int maxLen = -1;
        int start = 0;

        //  2轮循环 遍历所有子串
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 当某个子串首位相等时
                    if (j - i == 1 || j - i == 2) {
                        //  两种情况 都认为符合子串  a “aa” b “aba”
                        dp[i][j] = true;
                    } else {
                        //  大于等于3时  最小首位差3，四个子字符串，那么子串也一定为回文,
                        dp[i][j] = dp[i + 1][j - 1];
                        //  dp[i + 1][j - 1] 在上一轮循环已经判断了是否为回文了
                    }
                } else {
                    dp[i][j] = false;
                }

                //  如果确定当前dp[i][j]是回文
                if (dp[i][j]) {
                    int currentLen = j - i + 1;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        start = i;
                    }
                }
            }
        }


        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
//        System.out.println(longestStrings("abccbaxxppppppppppppppppppppppppppppppppppppppppppppppppp"));
        System.out.println(longestPalindrome("abacbaxx"));
    }
}
