package com.coding.practice._0_99;

/*
EASY
83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

import com.coding.practice.util.ListNode;

public class LeetCode_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == prev.val) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
}
