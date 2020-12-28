package com.feng.algorithmlists.双指针遍历.q3_无重复字符串的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fengbei
 * on 20-12-21
 * Hash+双指针滑动窗口 o(n)
 * * 示例：
 * *
 * * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * *
 * * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * *
 * * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int len = s.length();
        int result = 0;
        Set<Character> set = new HashSet<>();
        // start++代表，如果窗口向后滑动时，出现了跟前边一样的字符(出现过的字符)，那重复的字符可能start那个位置的字符，也可能是前边字符串中start靠后位置的字符，
        // start++的目的是逐步将头部缩短，以达到将重复字符排除在外的目的。举例子好理解一些: abcb***，窗口是[0,1)[0,2)[0,3)，对应的是a,ab,abc,都没有重复字符，到[0,4)时，abcb,
        // 发现b在HashSet中已经出现过，这时候移除start++对应的字符，注意此时end没有++，得到[1,4), bcb,然后继续在while中执行，发现e
        // nd对应的字符仍然在set中出现过，继续移除start++对应的字符，得到[2,4),即cb，此时再进入循环执行，已经没有重复的了，将向后继续滑动窗口，执行end++
        while (start < len && end < len) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
