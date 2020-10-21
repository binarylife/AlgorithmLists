package com.feng.algorithmlists.分治法.q23_合并K个排序链表;

import org.w3c.dom.ls.LSException;

/**
 * Created by fengbei
 * on 20-10-16
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {


    public static ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int i = 0;
        int j = lists.length - 1;
        ListNode finalList = unmerge(lists, i, j);
        return finalList;
    }

    private static ListNode unmerge(ListNode[] lists, int i, int j) {

        if (i == j) {
            return lists[i];
        } else {
            int mid = (i + j) / 2;
            ListNode left = unmerge(lists, i, mid);
            ListNode right = unmerge(lists, mid + 1, j);
            return merge2List(left, right);
        }
    }


    /**
     * 两个有序链表的合并
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge2List(ListNode l1, ListNode l2) {


        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.value < l2.value) {
            //  后面的头结点大于前面的
            l1.next = merge2List(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2List(l1, l2.next);
            return l2;
        }
    }


    static void printListNodes(ListNode head) {
        if (head.next == null) {
            return;
        }
        System.out.print(head.value);
        printListNodes(head.next);
    }


    public static void main(String[] args) {
        ListNode ListNode01 = new ListNode(1);
        ListNode ListNode02 = new ListNode(2);
        ListNode ListNode03 = new ListNode(3);
        ListNode ListNode04 = new ListNode(4);
        ListNode ListNode05 = new ListNode(5);
        ListNode ListNode06 = new ListNode(6);
        ListNode ListNode10 = new ListNode(10);
        ListNode ListNode11 = new ListNode(11);
        ListNode ListNode12 = new ListNode(12);
        ListNode ListNode13 = new ListNode(13);
        ListNode ListNode14 = new ListNode(14);

        ListNode01.next = ListNode02;
        ListNode02.next = ListNode03;
        ListNode03.next = ListNode04;
        ListNode04.next = ListNode05;

        ListNode10.next = ListNode11;
        ListNode11.next = ListNode12;
        ListNode12.next = ListNode13;
        ListNode13.next = ListNode14;

//        printListNodes(ListNode01);
//        printListNodes(ListNode10);

        mergeLists(new ListNode[]{ListNode01, ListNode10});
        printListNodes(ListNode01);
    }
}
