package com.feng.algorithmlists.分治法.q33_搜索排序旋转后的数组;

/**
 * Created by fengbei
 * on 20-10-20
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Solution {


    public static int search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            //  找到了目标值
            return mid;
        }

        if (nums[mid] > nums[low]) {
            // 前半段有序，后半段无序
            if (nums[low] <= target && nums[mid] > target) {
                // 在前半段的话，直接二分查找
                return search(nums, low, mid - 1, target);
            } else {
                // 在后半段无序中，需要继续拆分有序无序点
                return search(nums, mid + 1, high, target);
            }

        } else {
            //前半段无序，后半段有序
            if (nums[mid] <= target && nums[high] > target) {
                //在后半段的话，直接二分找
                return search(nums, mid + 1, high, target);
            } else {
                return search(nums, low, mid - 1, target);
            }
        }
    }
}
