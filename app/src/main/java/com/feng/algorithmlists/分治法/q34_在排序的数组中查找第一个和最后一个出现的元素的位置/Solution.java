package com.feng.algorithmlists.分治法.q34_在排序的数组中查找第一个和最后一个出现的元素的位置;

/**
 * Created by fengbei
 * on 20-10-16
 */
public class Solution {


    /**
     * 数组中出现的最后一个
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        int result = -1;
        while (low <= high) {


            if (nums[mid] < target) {
                //  目标值在右半部分
                low = mid + 1;
            } else if (nums[mid] > target) {
                //   目标在左半部分
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        return result;
    }


    /**
     * 查找数组中出现的第一个
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = (low + high) / 2;
        int result = -1;
        while (low <= high) {
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] ints = {2, 5, 9, 10, 13, 13, 13, 13, 57, 90, 99};
        System.out.println(findFirst(ints, 13));
        System.out.println(findLast(ints, 13));
    }
}
