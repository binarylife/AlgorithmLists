package com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.f2;

import com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.TreeNode;

import java.util.IllegalFormatCodePointException;

/**
 * Created by fengbei
 * on 20-10-10
 * 寻找上下边界递归
 */
public class Solution {


    public boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }


        int val = root.val;

        if (min != null && val <= min) {
            //  左子节点大于val
            return false;
        }

        if (max != null && val >= max) {
            //  右子节点下雨val
            return false;
        }


        //递归左子节点开始

        if (!valid(root.left, min, val))
            return false;

        if (!valid(root.right, val, max))
            return false;

        return true;
    }
}
