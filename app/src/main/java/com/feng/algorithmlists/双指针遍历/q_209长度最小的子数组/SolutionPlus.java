package com.feng.algorithmlists.双指针遍历.q_209长度最小的子数组;

/**
 * Created by fengbei
 * on 20-12-28
 */
public class SolutionPlus {


    public static int minSubArraylen(int s, int[] nums) {

        int start = 0;
        int len = 0;
        int sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum > s) {
                //  超出了目标值
                if (len == 0) {
                    len = j - start + 1;
                } else {
                    sum -= nums[start++];
                    len = Math.min(len, j - start + 1);
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {

        int nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArraylen(7, nums));
    }
}
