package com.feng.algorithmlists.hash相关.q387_字符串中的第一个唯一字符;

import java.util.HashMap;

/**
 * Created by fengbei
 * on 20-10-9
 * 字符串中第一个唯一字符
 */
public class Solution {

    public int firstuniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        //统计每次字符次数
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        //  查找等于1的字符
        for (int i = 0; i < n; i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
