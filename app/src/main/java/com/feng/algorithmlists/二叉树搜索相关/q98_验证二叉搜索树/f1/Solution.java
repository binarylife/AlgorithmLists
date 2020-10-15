package com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.f1;

import com.feng.algorithmlists.二叉树搜索相关.q98_验证二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengbei
 * on 20-10-10
 * 递归的中序遍历 （二叉搜索树的中序遍历是有序的 o（n））
 */
public class Solution {


    List<Integer> rs = new ArrayList();


    //  中序遍历格式   中序遍历后按照 大小顺序存入集合list，
    private List<Integer> ldr(TreeNode root) {
        if (root == null) {
            return rs;
        }
        ldr(root.left);
        rs.add(root.val);
        System.out.println(root.val);
        ldr(root.right);
        return rs;
    }

    //  遍历判断
    public boolean isValid(TreeNode root) {
        ldr(root);
        if (rs.size() < 2) {
            return true;
        }

        int firstVal = rs.get(0);
        for (int i = 0; i < rs.size(); i++) {
            if (rs.get(i) < firstVal) {
                return false;
            }
            firstVal = rs.get(i);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(11);

        root.left = left;
        root.right = right;


        TreeNode left01 = new TreeNode(3);
        TreeNode right02 = new TreeNode(9);

        left.left = left01;
        left.right = right02;
        System.out.println(new Solution().isValid(root));
    }
}
