package com.feng.algorithmlists.区间合并.q56_合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by fengbei
 * on 20-12-18
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Solution {

    public static int[][] merge(int[][] intervals) {
        //  1.将所有区间按照起始位置升序排序

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        //  2.遍历判断 当前区间的结束位置与后一区间的起始位置的大小 ，若后者小于前置，则可以合并

        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i < intervals.length - 1 && intervals[i + 1][0] <= end) {
                //  下一个区间的开始小于上一个区间的结束
                //   接着判断下一个区间的end是否大于上一个区间的end
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            arrayList.add(new int[]{start, end});
        }
        return arrayList.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {5, 10}, {15, 18}};
        int[][] merge = merge(ints);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]);
        }
    }
}
