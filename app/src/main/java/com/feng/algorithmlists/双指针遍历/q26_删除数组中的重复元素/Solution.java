package com.feng.algorithmlists.双指针遍历.q26_删除数组中的重复元素;

/**
 * Created by fengbei
 * on 20-12-25
 */
public class Solution {

    public int removeDuplicates(int nums[]) {
        if (nums.length < 2) {
            return nums.length;
        }

        int c = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[c]) {
//                下一个与上一个不相等 左指针右移
                c++;
                nums[c] = nums[i];
            }
        }
        return c + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
    }
}
