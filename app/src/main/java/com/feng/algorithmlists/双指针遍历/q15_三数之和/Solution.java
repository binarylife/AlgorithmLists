package com.feng.algorithmlists.双指针遍历.q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fengbei
 * on 20-12-24
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class Solution {


    /**
     * 有序数组的两数之和
     *
     * @param a
     * @param target
     * @return
     */
    public static int[] twoSum(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int[] result = {-1, -1};
        while (low < high) {
            if (target == a[low] + a[high]) {
                //  找到了对应的两个数
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else {
                if (target < a[low] + a[high]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }

    /**
     * 三个数之和等于0
     * 本题需要找到三个和为 0 的元素，对数组排序后，遍历数组，以当前元素的相反
     * 数为两数和，然后在当前元素后的所有元素范围内使用双指针算法寻找另两个元素
     *
     * @return
     */
    public static ArrayList<Integer> threeSum(int[] a) {
        Arrays.sort(a);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            int low = i + 1;
            int high = a.length - 1;
            int sum = 0 - a[i];

            while (low < high) {
                if (a[low] + a[high] > sum) {
                    high--;
                } else if (a[low] + a[high] < sum) {
                    low++;
                } else {
                    arrayList.add(a[i]);
                    arrayList.add(a[low]);
                    arrayList.add(a[high]);
                    return arrayList;
                }
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        int[] s = new int[]{1, 8, 6, -2, 5, -4, 8, 3, 7};
        Arrays.sort(s);
        int[] ints = twoSum(s, 7);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
//        ArrayList<Integer> integers = threeSum(s);
//        System.out.println(integers.get(0));
//        System.out.println(integers.get(1));
//        System.out.println(integers.get(2));
    }
}
