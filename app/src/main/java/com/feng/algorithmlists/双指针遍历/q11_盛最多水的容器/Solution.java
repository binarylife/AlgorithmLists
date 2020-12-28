package com.feng.algorithmlists.双指针遍历.q11_盛最多水的容器;

/**
 * Created by fengbei
 * on 20-12-22
 * 这种方法如何工作？
 * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。如果我们试图将指向较长线段的指针向内侧移动，
 * 矩形区域的面积将受限于较短的线段而不会获得任何增加。但是，在同样的条件下，移动指向较短线段的指针尽管造成
 * 了矩形宽度的减小，但却可能会有助于面积的增大。因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
 */
public class Solution {

    public static int maxArea(int[] height) {
        if (height == null && height.length == 0) {
            return 0;
        }

        int low = 0;
        int high = height.length - 1;
        int max = 0;


        //  开启双指针轮训

        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            max = Math.max(max, area);

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] s = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(s));
    }
}
