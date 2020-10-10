package com.feng.algorithmlists.hash相关.q1_数组内两数之和;

import java.util.HashMap;

/**
 * Created by fengbei
 * on 20-10-9
 * 寻找数组中两个数相加等于目标数值
 */
public class Solution {


    /**
     * 暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                    return result;
                }
            }
        }
        return null;
    }


    public int[] twoSumPro(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), nums[i]};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
