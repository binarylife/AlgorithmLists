package com.feng.algorithmlists.二叉树搜索相关.q450_删除搜索树中的节点;

import com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.TreeNode;

/**
 * Created by fengbei
 * on 20-10-12
 * 删除二叉搜索树的指定节点
 */
public class Solution {


    /**
     * 通过谦虚节点替换法
     *
     * @param root
     * @param key
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        // 先判断要删除的key是否在此树中
        if (!containNode(root, key)) {
            return root;
        }

        if (root.val == key) {
            //找到待删除的节点

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //  寻找后继节点
            TreeNode successor = findMin(root.right);
            //  删除最小节点
            successor.right = defMin(root.right);
            successor.left = root.left;
            return successor;
        } else if (root.val < key) {
            //右子树寻找
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            //左子树寻找
            root.left = deleteNode(root.left, key);
            return root;
        }

    }

    /**
     * 返回一个删除了最小节点后的 treeNode 的根节点
     */
    private TreeNode defMin(TreeNode treeNode) {
        if (treeNode.left == null) {
            return treeNode.right;
        }
        treeNode.left = defMin(treeNode.left);
        return treeNode;
    }

    /**
     * 寻找后续节点，返回当前子树最小的节点
     *
     * @param treeNode
     */
    private TreeNode findMin(TreeNode treeNode) {
        if (treeNode.left == null) {
            return treeNode;
        }
        return findMin(treeNode.left);
    }


    /**
     * 判断key是否在此树中
     *
     * @param root
     * @param key
     * @return
     */
    private boolean containNode(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.val) {
            return true;
        } else if (key > root.val) {
            return containNode(root.right, key);
        } else {
            return containNode(root.left, key);
        }
    }

}
