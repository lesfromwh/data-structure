package com.link;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author liushuang 2019/8/10
 */
public class Leetcode21 {
    //复杂度O(l1长度+l2长度)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //终止条件,返回值
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //每层递归内容
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
