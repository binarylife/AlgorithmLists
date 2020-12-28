package com.feng.algorithmlists.双指针遍历.q_209长度最小的子数组;

/**
 * Created by fengbei
 * on 20-12-28
 */
public class Solution {


    public static int minSubArraylen(int s, int[] nums) {

        //  左指针
        int i = 0;
        int sum = 0;
        //  右指针
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            //  从0开始累加
            sum += nums[j];
            while (sum > s) {
                //  当累加值大于目标值s时，记录当前数组的长度
                if (len == 0) {
                    // len还没有赋值  则赋值当前最大inde减去最小index
                    len = j - i + 1;
                } else {
                    //  len已经赋值过值了，则移动左指针i，判断减去i后的数组是否还是符合需求数组
                    sum -= nums[i++];
                    len = Math.min(len, j - i + 1);
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
