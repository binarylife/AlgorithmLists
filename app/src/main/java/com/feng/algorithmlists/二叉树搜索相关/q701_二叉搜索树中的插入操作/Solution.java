package com.feng.algorithmlists.二叉树搜索相关.q701_二叉搜索树中的插入操作;

import com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.TreeNode;

/**
 * Created by fengbei
 * on 20-10-14
 */
public class Solution {

    public TreeNode insertBST(TreeNode root, int key) {
        TreeNode treeNode = new TreeNode(key);
        TreeNode temp = root;
        if (root == null) {
            return treeNode;
        }

        if (key > root.val) {
            //  右子树添加
            if (root.right == null) {
                root.right = treeNode;
            } else {
                insertBST(root.right, key);
            }

        } else {
            //  左子树添加
            if (root.left == null) {
                root.left = treeNode;
            } else {
                insertBST(root.left, key);
            }
        }
        return temp;
    }
}
