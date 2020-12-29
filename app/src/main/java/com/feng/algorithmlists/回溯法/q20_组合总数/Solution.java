package com.feng.algorithmlists.回溯法.q20_组合总数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fengbei
 * on 20-12-29
 */
public class Solution {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //  最终结果list
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        //  排序数组
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<Integer>(), res);
        return res;
    }


    /**
     * @param candidates 目标数组
     * @param target     目标值
     * @param start      每次轮训的开启位置
     * @param stack      临时栈 ，可做数回溯
     * @param res        最终存储结果
     */
    public static void helper(int[] candidates, int target, int start, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (start > candidates.length) {
            //  跳出递归
            return;
        }
        if (target == 0 && stack.size() > 0) {
            //  递归的找到了目标子数组
            ArrayList<Integer> list = new ArrayList<>(stack);
            res.add(list);
        }

        //  去重set
        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i < candidates.length; i++) {
            if (!set.contains(candidates[i]) && target >= candidates[i]) {
                stack.push(candidates[i]);
                //  递归的调用后续位置的index
                helper(candidates, target - candidates[i], 1 + i, stack, res);
                //  跳出当前轮的递归后,清空stack，
                stack.pop();
                //  当前i为起点的轮完成了，进入下一轮i++递归
                set.add(candidates[i]);
            }
        }

    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.println(lists.get(i).get(j));
            }
            System.out.println("0000000000000000000000000000000");
        }

    }
}
